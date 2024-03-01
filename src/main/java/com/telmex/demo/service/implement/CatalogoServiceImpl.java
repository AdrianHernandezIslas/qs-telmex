package com.telmex.demo.service.implement;

import com.telmex.demo.entity.*;
import com.telmex.demo.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class CatalogoServiceImpl implements CatalogoService {

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    private final String PREFIX_QUERY_SELECT = "from ";


    @Override
    public List<TipoEmpleado> findAllTipoEmpleado() {
        return findAll(TipoEmpleado.class);
    }

    @Override
    public List<EstatusEmpleado> findAllEstatusEmpleado() {
        return findAll(EstatusEmpleado.class);
    }

    @Override
    public List<PerfilEmpleado> findAllPerfil() {
        return findAll(PerfilEmpleado.class);
    }

    @Override
    public List<Genero> findAllGenero() {
         return findAll(Genero.class);
    }

    @Override
    public List<TipoCliente> findAllTipoCliente() {
        return findAll(TipoCliente.class);
    }

    @Override
    public List<TipoServicio> findAllTipoServicio() {
        return findAll(TipoServicio.class);
    }

    @Override
    public List<PorcentajeComision> findAllPorcentajeComision() {
        return findAll(PorcentajeComision.class);
    }

    @Override
    public List<PagoConcepto> findAllPagoConcepto() {
        return findAll(PagoConcepto.class);
    }

    @Override
    public List<UserRole> findAllRoles() {
        return findAll(UserRole.class);
    }

    protected <T> List<T> findAll(Class<T> tClass){
        String query = PREFIX_QUERY_SELECT.concat(tClass.getSimpleName());
        return getCurrentSession().createQuery(query).getResultList();

    }

    protected EntityManager getCurrentSession() {
        return entityManagerFactory.createEntityManager();
    }
}
