package com.telmex.demo.service.implement;

import com.telmex.demo.constants.EstadoCargaConstants;
import com.telmex.demo.entity.EstadoCuenta;
import com.telmex.demo.entity.EstadoCuentaDetalle;
import com.telmex.demo.entity.EstatusCarga;
import com.telmex.demo.repository.EstadoCuentaDetalleRepository;
import com.telmex.demo.repository.EstadoCuentaRepository;
import com.telmex.demo.service.EstadoCuentaService;
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
        insertThread(estadoCuentaDetalleSet);
        Instant end = Instant.now();
        System.out.println("Elapsed Threads Time: " + Duration.between(begin, end).toString());
    }

    @Override
    public void updateStatusEstadoCuenta(Integer idEstadoCuenta, EstatusCarga estatusCarga) {
        EstadoCuenta estadoCuenta = estadoCuentaRepository.findById(idEstadoCuenta).get();
        estadoCuenta.setEstatusCarga(estatusCarga);
        estadoCuentaRepository.save(estadoCuenta);
    }


    @Async
    public void insertThread(Set<EstadoCuentaDetalle> estadoCuentaDetalleSet) {
        CountDownLatch latch = new CountDownLatch(estadoCuentaDetalleSet.size());
        ExecutorService executor = Executors.newFixedThreadPool(estadoCuentaDetalleSet.size());
        estadoCuentaDetalleSet.forEach((estadoCuentaDetalle) -> {
            executor.execute(new ActionService(latch, estadoCuentaDetalleRepository, estadoCuentaDetalle));
        });
        executor.shutdown();

        try {
            Instant begin = Instant.now();
            latch.await();
            updateStatusEstadoCuenta(estadoCuentaDetalleSet.iterator().next().getEstadoCuenta().getIdEstadoCuenta(), EstadoCargaConstants.FINALIZADO);
            Instant end = Instant.now();
            System.out.println("Elapsed INSERT Time: " + Duration.between(begin, end).toString());

        } catch (InterruptedException ex) {
            updateStatusEstadoCuenta(estadoCuentaDetalleSet.iterator().next().getEstadoCuenta().getIdEstadoCuenta(), EstadoCargaConstants.FALLIDO);
            System.out.println(ex);
        }

        System.out.println("End of Action Services");
    }


}

class ActionService implements Runnable {
    private final CountDownLatch latch;
    private final EstadoCuentaDetalleRepository estadoCuentaDetalleRepository;

    private final EstadoCuentaDetalle estadoCuentaDetalle;

    public ActionService(CountDownLatch latch, EstadoCuentaDetalleRepository estadoCuentaDetalleRepository, EstadoCuentaDetalle estadoCuentaDetalle) {
        this.latch = latch;
        this.estadoCuentaDetalleRepository = estadoCuentaDetalleRepository;
        this.estadoCuentaDetalle = estadoCuentaDetalle;
    }

    @Override
    public void run() {
        estadoCuentaDetalleRepository.save(estadoCuentaDetalle);
        this.latch.countDown();
    }


}
