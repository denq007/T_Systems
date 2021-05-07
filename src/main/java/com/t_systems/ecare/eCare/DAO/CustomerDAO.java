package com.t_systems.ecare.eCare.DAO;

import com.t_systems.ecare.eCare.entity.Customer;
import com.t_systems.ecare.eCare.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

@Repository
public class CustomerDAO extends GenericDAO<Customer>{
   /* public CustomerDAO() {
        setClazz(Customer.class);
    }*/

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

    public Customer getCustomerIDBYUserID(int userID) {
        try {
            Customer customer=sessionFactory.getCurrentSession().createQuery("from Customer u where u.user.id =: user_id", Customer.class)
                    .setParameter("user_id", userID)
                    .getSingleResult();
            return customer;
        }catch (NoResultException e)
        {
            return null;
        }

    }

}
