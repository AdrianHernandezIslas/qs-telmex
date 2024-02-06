package com.telmex.demo.service.implement;

import com.google.common.collect.Lists;
import com.telmex.demo.components.SpeakerPublisher;
import com.telmex.demo.constants.EstadoCargaConstants;
import com.telmex.demo.entity.EstadoCuenta;
import com.telmex.demo.entity.EstadoCuentaDetalle;
import com.telmex.demo.entity.EstatusCarga;
import com.telmex.demo.models.SpeechEvent;
import com.telmex.demo.repository.EstadoCuentaDetalleRepository;
import com.telmex.demo.repository.EstadoCuentaRepository;
import com.telmex.demo.service.EstadoCuentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class EstadoCuentaServiceImpl implements EstadoCuentaService {

    @Autowired
    private EstadoCuentaRepository estadoCuentaRepository;

    @Autowired
    private EstadoCuentaDetalleRepository estadoCuentaDetalleRepository;

    @Autowired
    private SpeakerPublisher speakerPublisher;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public EstadoCuenta create(EstadoCuenta estadoCuenta) {
        EstadoCuenta estadoCuentaPadre = estadoCuentaRepository.saveAndFlush(estadoCuenta);
        return estadoCuentaPadre;
    }

    @Override
    public Optional<EstadoCuenta> get(Integer idEstadoCuenta) {
        return estadoCuentaRepository.findById(idEstadoCuenta);
    }

    @Override
    public Page<EstadoCuenta> getAll(Pageable page) {
        return estadoCuentaRepository.findAll(page);
    }

    @Override
    public EstadoCuenta update(EstadoCuenta estadoCuenta) {
        return estadoCuentaRepository.save(estadoCuenta);
    }

    @Override
    public void delete(Integer idEstadoCuenta) {
        estadoCuentaRepository.deleteById(idEstadoCuenta);
    }

    @Override
    public Optional<EstatusCarga> ckeckEstatus(Integer idEstadoCuenta) {
        Optional<EstatusCarga> estadoCuenta = estadoCuentaRepository.checkById(idEstadoCuenta);
        return estadoCuenta;
    }

    @Override
    @Async
    public void addDetalle(Set<EstadoCuentaDetalle> estadoCuentaDetalleSet) {
        Instant begin = Instant.now();
        insertData(estadoCuentaDetalleSet);
        if(!estadoCuentaDetalleSet.isEmpty()){
            EstadoCuenta ec = estadoCuentaDetalleSet.iterator().next().getEstadoCuenta();
            ec.setEstatusCarga(EstadoCargaConstants.FINALIZADO);
            speakerPublisher.speak(new SpeechEvent<EstadoCuenta>(this,ec,1));
            updateStatusEstadoCuenta(ec.getIdEstadoCuenta(),EstadoCargaConstants.FINALIZADO);
        }
        Instant end = Instant.now();
        logger.info("Termina agregar detalle : " + Duration.between(begin, end).toString());
    }

    @Override
    public void updateStatusEstadoCuenta(Integer idEstadoCuenta, EstatusCarga estatusCarga) {
        EstadoCuenta estadoCuenta = estadoCuentaRepository.findById(idEstadoCuenta).get();
        estadoCuenta.setEstatusCarga(estatusCarga);
        estadoCuentaRepository.save(estadoCuenta);
    }

    public void insertData(Set<EstadoCuentaDetalle> estadoCuentaDetalleSet){
        logger.info("Inicia insertar detalle : ");
        List<EstadoCuentaDetalle> data = new ArrayList(estadoCuentaDetalleSet);
        List<List<EstadoCuentaDetalle>> dataPaginated = Lists.partition(data,50);
        dataPaginated.parallelStream().forEach(this::saveDetalle);
        logger.info("Termina insertar detalle : ");
    }

    public void saveDetalle(List<EstadoCuentaDetalle> detalles){
        estadoCuentaDetalleRepository.saveAll(detalles);
    }

}
