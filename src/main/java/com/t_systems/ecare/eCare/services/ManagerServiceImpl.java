package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.Converter.CustomerConverter;
import com.t_systems.ecare.eCare.Converter.CustomerConverterImpl;
import com.t_systems.ecare.eCare.DAO.CustomerDAO;
import com.t_systems.ecare.eCare.DTO.CustomerDTO;
import com.t_systems.ecare.eCare.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    CustomerDAO customerDAO;
    @Autowired
    CustomerConverter customerConverter;

    @Transactional
    public List<CustomerDTO> getAllCustomer()
    {
        List<Customer>list= customerDAO.findAll();
        return list.stream().map(s->customerConverter.converterCustomerToCustomerDTO(s)).collect(Collectors.toList());
    }

    @Transactional
    public Optional<String> saveCustomer(CustomerDTO customerDTO)
    {
        if (customerDAO.getCustomerByPassport(customerDTO.getCustomerPassportDetails()) != null)
            return Optional.of("passportId is reserved");
        Customer customer= customerConverter.converterCustomerDTOToCustomer(customerDTO);
        customerDAO.save( customer);
        return Optional.empty();
    }
    public void ubdateData(Customer customer,CustomerDTO customerDTO)
    {
        customer.setName(customerDTO.getCustomerName());
        customer.setSurname(customerDTO.getCustomerSurname());
        customer.setAddress(customerDTO.getCustomerAdress());
        customer.setBirthDate(customerDTO.getCustomerBirthDate());
        customer.setPassportDetails(customerDTO.getCustomerPassportDetails());

    }
}
