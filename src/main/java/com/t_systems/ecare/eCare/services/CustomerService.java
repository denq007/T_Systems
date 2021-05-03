package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomer();
    public void saveCustomer(Customer customer);
}
