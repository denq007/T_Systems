package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.Converter.CustomerConverter;
import com.t_systems.ecare.eCare.DAO.CustomerDAO;
import com.t_systems.ecare.eCare.DAO.UserDao;
import com.t_systems.ecare.eCare.DTO.CustomerDTO;
import com.t_systems.ecare.eCare.entity.Customer;
import com.t_systems.ecare.eCare.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerDAO customerDAO;
    @Autowired
    CustomerConverter customerConverter;
    @Autowired
    UserDao userDao;

    @Transactional
    public CustomerDTO getCustomerDTOwithoutContractsByEmailUser(String username){
        return customerConverter.converterCustomerToCustomerDTO(customerDAO.getCustomerIDBYUserID(
                userDao.getUserByUsername(username).getId()));
    }


    @Override
    public Optional<String> update(CustomerDTO dto) {
        Customer customer=customerDAO.findOne(dto.getCustomerID());
        customer=customerConverter.converterCustomerDTOToCustomer(dto);
        customerDAO.update(customer);
        return Optional.empty();
    }



}
