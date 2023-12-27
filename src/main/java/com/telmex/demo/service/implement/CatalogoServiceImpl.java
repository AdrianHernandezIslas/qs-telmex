package com.telmex.demo.service.implement;

import com.telmex.demo.entity.EstatusEmpleado;
import com.telmex.demo.entity.TipoEmpleado;
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
        return getCurrentSession().createQuery(PREFIX_QUERY_SELECT.concat(TipoEmpleado.class.getName())).getResultList();
    }

    @Override
    public List<EstatusEmpleado> findAllEstatusEmpleado() {
        return getCurrentSession().createQuery(PREFIX_QUERY_SELECT.concat(EstatusEmpleado.class.getName())).getResultList();
    }

    protected EntityManager getCurrentSession() {
        return entityManagerFactory.createEntityManager();
    }
}
