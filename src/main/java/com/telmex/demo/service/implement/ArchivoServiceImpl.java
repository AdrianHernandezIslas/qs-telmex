package com.telmex.demo.service.implement;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.telmex.demo.components.SpeakerPublisher;
import com.telmex.demo.constants.ArchivoContants;
import com.telmex.demo.constants.EstadoCargaConstants;
import com.telmex.demo.constants.NotificationConstants;
import com.telmex.demo.dto.RowEstadoCuenta;
import com.telmex.demo.dto.excel.BookDto;
import com.telmex.demo.dto.excel.SheetDto;
import com.telmex.demo.dto.mapper.EstadoCuentaDetalleMapper;
import com.telmex.demo.entity.*;

import com.telmex.demo.models.SpeechEvent;
import com.telmex.demo.service.ArchivoService;
import com.telmex.demo.service.EstadoCuentaService;
import com.telmex.demo.components.ExcelReaderService;
import com.telmex.demo.service.NotificacionService;
import com.telmex.demo.service.external.sftp.FtpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

import java.util.Date;
import java.util.List;

import java.util.Set;

@Service
public class ArchivoServiceImpl implements ArchivoService {

    @Autowired
    private FtpService ftpService;
    @Autowired
    private ExcelReaderService excelReaderService;
    @Autowired
    private EstadoCuentaDetalleMapper estadoCuentaDetalleMapper;
    @Autowired
    private EstadoCuentaService estadoCuentaService;
    @Autowired
    private SpeakerPublisher speakerPublisher;

    @Autowired
    private NotificacionService notificacionService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public EstadoCuenta procesarArchivoEstadoCuenta(LocalDate fechaArchivo, UserSession session) {
        String nameFile = getNameFile(fechaArchivo);
        EstadoCuenta estadoCuenta = createEstadoCuenta( fechaArchivo,session);
        procesarArchivo(nameFile,estadoCuenta);
        return estadoCuenta;
    }


    @Async
    public void procesarArchivo(String nameFile, EstadoCuenta estadoCuenta)  {
        UserSession session = estadoCuenta.getSession();
        Thread hilo = new Thread(){
            @Override
            public void run() {
                try {

                    estadoCuentaService.updateStatusEstadoCuenta(estadoCuenta.getIdEstadoCuenta(),EstadoCargaConstants.INICIADO);
                    publicarNotificacion(crearNotification(NotificationConstants.INFO,session,EstadoCargaConstants.INICIADO),session.getIdSesion());
                    logger.info("Inicia obtener archivo");
                    Instant begin = Instant.now();
                    File file = ftpService.getFile(nameFile);
                    logger.info("Termina obtener archivo");
                    estadoCuentaService.updateStatusEstadoCuenta(estadoCuenta.getIdEstadoCuenta(),EstadoCargaConstants.PROCESANDO);
                    publicarNotificacion(crearNotification(NotificationConstants.INFO,session,EstadoCargaConstants.PROCESANDO),session.getIdSesion());
                    BookDto<SheetDto<RowEstadoCuenta>> book = excelReaderService.getFileEstadoCuenta(file);
                    createEstadoCuentaDetalle(book, estadoCuenta);
                    ftpService.chanelExit();
                    Instant end = Instant.now();
                    logger.info("Termina procesar archivo: " + Duration.between(begin, end).toString());
                }catch (JSchException | SftpException e) {
                    logger.error("Error al obtener archivo {}",e);
                    estadoCuentaService.updateStatusEstadoCuenta(estadoCuenta.getIdEstadoCuenta(),EstadoCargaConstants.ARCHIVO_NO_ENCONTRADO);
                    publicarNotificacion(crearNotification(NotificationConstants.INFO,session,EstadoCargaConstants.ARCHIVO_NO_ENCONTRADO),session.getIdSesion());
                }  catch (IOException e) {
                    logger.error("Error al obtener archivo {}",e);
                    estadoCuentaService.updateStatusEstadoCuenta(estadoCuenta.getIdEstadoCuenta(),EstadoCargaConstants.FALLIDO);
                    publicarNotificacion(crearNotification(NotificationConstants.INFO,session,EstadoCargaConstants.FALLIDO),session.getIdSesion());
                }
            }
        };
        hilo.start();
    }

    @Async
    public void createEstadoCuentaDetalle(BookDto<SheetDto<RowEstadoCuenta>> book, EstadoCuenta estadoCuenta) {
        List<RowEstadoCuenta> list = book.getSheets().get(0).getRows();
        estadoCuentaDetalleMapper.setEstadoCuenta(estadoCuenta);
        Set<EstadoCuentaDetalle> detalleEstadoCuenta = estadoCuentaDetalleMapper.map(list);
        estadoCuentaService.addDetalle(detalleEstadoCuenta);
    }

    private EstadoCuenta createEstadoCuenta(LocalDate fechaArchivo,UserSession session) {
        EstadoCuenta estadoCuenta = new EstadoCuenta();
        estadoCuenta.setEstadoCuenta(ArchivoContants.DATE_FORMAT.format(fechaArchivo));
        estadoCuenta.setNombreArchivo(getNameFile(fechaArchivo));
        estadoCuenta.setEstatusCarga(EstadoCargaConstants.INICIADO);
        estadoCuenta.setSession(session);
        return estadoCuentaService.create(estadoCuenta);
    }

    private String getNameFile(LocalDate fechaArchivo) {
        String fecha = ArchivoContants.DATE_FORMAT.format(fechaArchivo);
        return ArchivoContants.NAME_FILE_PREFIX + fecha + ArchivoContants.EXTENSION_FILE;
    }

    private Notificacion crearNotification(Notificacion.NotificacionBuilder notificacion, UserSession userSession, EstatusCarga estatusCarga) {
        notificacion.titulo("CARGA DE ARCHIVO");
        notificacion.descripcion("La carga de archivo cambio de estado a "+estatusCarga.getEstatusCarga());
        notificacion.fechaCreacion(new Date());
        notificacion.usuario(userSession.getUsuario());
        return  notificacion.build();
    }

    private void publicarNotificacion(Notificacion notificacion,Long idSession){
        Notificacion newNotificacion = notificacionService.create(notificacion);
        speakerPublisher.speak(new SpeechEvent<Notificacion>(this,newNotificacion,idSession));
    }
}
