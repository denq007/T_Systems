package com.t_systems.ecare.eCare.DAO;

import com.t_systems.ecare.eCare.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO extends AbstractHibernateDAO{
    public CustomerDAO() {
        setClazz(Customer.class);
    }


}
