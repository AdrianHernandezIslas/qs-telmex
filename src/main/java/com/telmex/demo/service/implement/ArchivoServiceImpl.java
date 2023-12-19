package com.telmex.demo.service.implement;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.telmex.demo.constants.ArchivoContants;
import com.telmex.demo.constants.EstadoCargaConstants;
import com.telmex.demo.dto.RowEstadoCuenta;
import com.telmex.demo.dto.excel.BookDto;
import com.telmex.demo.dto.excel.SheetDto;
import com.telmex.demo.dto.mapper.EstadoCuentaDetalleMapper;
import com.telmex.demo.entity.EstadoCuenta;
import com.telmex.demo.entity.EstadoCuentaDetalle;

import com.telmex.demo.service.ArchivoService;
import com.telmex.demo.service.EstadoCuentaService;
import com.telmex.demo.service.ExcelReaderService;
import com.telmex.demo.service.external.sftp.FtpService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

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

    @Override
    public EstadoCuenta procesarArchivoEstadoCuenta(LocalDate fechaArchivo) {
        String nameFile = getNameFile(fechaArchivo);
        EstadoCuenta estadoCuenta = createEstadoCuenta( fechaArchivo);
        procesarArchivo(nameFile,estadoCuenta);
        return estadoCuenta;
    }


    private void procesarArchivo(String nameFile, EstadoCuenta estadoCuenta)  {
        Thread hilo = new Thread(){
            @Override
            public void run() {
                try {
                    estadoCuentaService.updateStatusEstadoCuenta(estadoCuenta.getIdEstadoCuenta(),EstadoCargaConstants.INICIADO);
                    System.out.println("Inicia obtener archivo");
                    Instant begin = Instant.now();
                    File file = ftpService.getFile(nameFile);
                    estadoCuentaService.updateStatusEstadoCuenta(estadoCuenta.getIdEstadoCuenta(),EstadoCargaConstants.PROCESANDO);
                    BookDto<SheetDto<RowEstadoCuenta>> book = excelReaderService.getFileEstadoCuenta(file);
                    createEstadoCuentaDetalle(book, estadoCuenta);
                    ftpService.chanelExit();
                    Instant end = Instant.now();
                    System.out.println("Elapsed Time: " + Duration.between(begin, end).toString());
                }catch (JSchException | SftpException e) {
                    System.out.println(e);
                    estadoCuentaService.updateStatusEstadoCuenta(estadoCuenta.getIdEstadoCuenta(),EstadoCargaConstants.ARCHIVO_NO_ENCONTRADO);
                }  catch (IOException e) {
                    System.out.println(e);
                    estadoCuentaService.updateStatusEstadoCuenta(estadoCuenta.getIdEstadoCuenta(),EstadoCargaConstants.FALLIDO);
                }
            }
        };
        hilo.start();
    }

    private void createEstadoCuentaDetalle(BookDto<SheetDto<RowEstadoCuenta>> book, EstadoCuenta estadoCuenta) {
        List<RowEstadoCuenta> list = book.getSheets().get(0).getRows();
        estadoCuentaDetalleMapper.setEstadoCuenta(estadoCuenta);
        Set<EstadoCuentaDetalle> detalleEstadoCuenta = estadoCuentaDetalleMapper.map(list);
        estadoCuentaService.addDetalle(detalleEstadoCuenta);
    }

    private EstadoCuenta createEstadoCuenta(LocalDate fechaArchivo) {
        EstadoCuenta estadoCuenta = new EstadoCuenta();
        estadoCuenta.setEstadoCuenta(ArchivoContants.DATE_FORMAT.format(fechaArchivo));
        estadoCuenta.setNombreArchivo(getNameFile(fechaArchivo));
        estadoCuenta.setEstatusCarga(EstadoCargaConstants.INICIADO);
        return estadoCuentaService.create(estadoCuenta);
    }


    private String getNameFile(LocalDate fechaArchivo) {
        String fecha = ArchivoContants.DATE_FORMAT.format(fechaArchivo);
        return ArchivoContants.NAME_FILE_PREFIX + fecha + ArchivoContants.EXTENSION_FILE;
    }
}
