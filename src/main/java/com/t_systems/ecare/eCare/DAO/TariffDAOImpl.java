package com.t_systems.ecare.eCare.DAO;

import com.t_systems.ecare.eCare.entity.Tariff;
import com.t_systems.ecare.eCare.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class TariffDAOImpl extends GenericDAO<Tariff> implements TariffDAO{
    @Transactional
    public List<Object[]> getAllTariffNamesAndIds()
    {
        return sessionFactory.getCurrentSession().createQuery("select t.id,t.name from Tariff t", Object[].class).getResultList();
    }
    @Autowired
    public void setClass() {
        this.setClass(Tariff.class);
    }
}
