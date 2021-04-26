package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DAO.CustomerDAO;
import com.t_systems.ecare.eCare.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
@Service
public class CustomerService {
    @Autowired
    CustomerDAO customerDAO;


    @Transactional
    public List<Customer>getAllCustomer()
    {
        return customerDAO.findAll();
    }

    @Transactional
    public void saveCustomer(Customer customer)
    {
        customerDAO.save( customer);
    }
}
