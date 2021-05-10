package com.t_systems.ecare.eCare.services;


import com.t_systems.ecare.eCare.DAO.CustomerDAO;
import com.t_systems.ecare.eCare.DAO.UserDao;
import com.t_systems.ecare.eCare.DTO.CustomerDTO;
import com.t_systems.ecare.eCare.DTO.UserDTO;
import com.t_systems.ecare.eCare.entity.Customer;
import com.t_systems.ecare.eCare.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
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
    UserDao userDao;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserService userService;


    public CustomerDTO convertToDto(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }
    public Customer convertToEntity(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
       /* userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));*/
        return customer;
    }

    @Transactional
    public CustomerDTO getCustomerDTOwithoutContractsByEmailUser(String username){
        return convertToDto(customerDAO.getCustomerIDBYUserID(
                userDao.getUserByUsername(username).getId()));
    }


    @Override
    @Transactional
    public Optional<String> update(CustomerDTO dto) {
        Customer customer=customerDAO.findOne(dto.getId());
        User user= customer.getUser();
        customer=convertToEntity(dto);
        customer.setUser(user);
        customerDAO.update(customer);
        return Optional.empty();
    }

    @Override
    @Transactional
    public CustomerDTO findById(int id) {
        CustomerDTO customerDTO=new CustomerDTO();
        Customer customer=  customerDAO.findOne(id);
        customerDTO=convertToDto(customer);
        customerDTO.setUser(userService.convertToDto(customer.getUser()));
        return  customerDTO;
    }




}
