package com.telmex.demo.service.implement;

import com.telmex.demo.entity.EstadoCuenta;
import com.telmex.demo.entity.EstadoCuentaDetalle;
import com.telmex.demo.entity.EstatusCarga;
import com.telmex.demo.repository.EstadoCuentaDetalleRepository;
import com.telmex.demo.repository.EstadoCuentaRepository;
import com.telmex.demo.service.EstadoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;

@Service
public class EstadoCuentaServiceImpl implements EstadoCuentaService {

    @Autowired
    private EstadoCuentaRepository estadoCuentaRepository;

    @Autowired
    private EstadoCuentaDetalleRepository estadoCuentaDetalleRepository;

    @Override
    public EstadoCuenta create(EstadoCuenta estadoCuenta) {
        EstadoCuenta estadoCuentaPadre = estadoCuentaRepository.saveAndFlush(estadoCuenta);
        return estadoCuentaPadre;
    }

    @Override
    @Async
    public void addDetalle(Set<EstadoCuentaDetalle> estadoCuentaDetalleSet) {
        Instant begin = Instant.now();
        estadoCuentaDetalleSet.forEach(this::insertThread);
        Instant end = Instant.now();
        System.out.println("Elapsed Time: " + Duration.between(begin, end).toString());
    }

    @Override
    public void updateStatusEstadoCuenta(Integer idEstadoCuenta, Integer idEstatusCarga) {
        EstadoCuenta estadoCuenta = estadoCuentaRepository.findById(idEstadoCuenta).get();
        EstatusCarga estatusCarga = new EstatusCarga();
        estatusCarga.setIdEstatusCarga(idEstatusCarga);
        estadoCuentaRepository.save(estadoCuenta);
    }

    @Async
    public void insertThread(EstadoCuentaDetalle estadoCuentaDetalle) {
        Thread hilo = new Thread() {
            @Override
            public void run() {
                try {
                    estadoCuentaDetalleRepository.save(estadoCuentaDetalle);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        hilo.start();
    }
}
