package com.t_systems.ecare.eCare.DAO;

import com.t_systems.ecare.eCare.entity.Customer;
import com.t_systems.ecare.eCare.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class CustomerDAO extends AbstractHibernateDAO{
    public CustomerDAO() {
        setClazz(Customer.class);
    }

    public Customer getCustomerByPassport(String passportDetails) {
        try {
            Customer customer=getCurrentSession().createQuery("from Customer u where u.passportDetails =: passport_details", Customer.class)
                    .setParameter("passport_details", passportDetails)
                    .getSingleResult();
            return customer;
        }catch (NoResultException e)
        {
            return null;
        }

    }
}
