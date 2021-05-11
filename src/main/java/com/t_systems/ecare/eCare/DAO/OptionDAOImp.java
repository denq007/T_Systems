package com.t_systems.ecare.eCare.DAO;

import com.t_systems.ecare.eCare.entity.Option;
import com.t_systems.ecare.eCare.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class OptionDAOImp extends GenericDAO<Option> implements OptionDAO{
    @Autowired
    public void setClass() {
        this.setClass(Option.class);
    }

    @Override
    @Transactional
    public List<Object[]> getAllOptionNamesAndIds() {
        return sessionFactory.getCurrentSession().createQuery("select o.id,o.name from Option o", Object[].class).getResultList();
    }
}
