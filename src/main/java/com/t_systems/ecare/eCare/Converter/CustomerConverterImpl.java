package com.t_systems.ecare.eCare.Converter;

import com.t_systems.ecare.eCare.DTO.ContractDTO;
import com.t_systems.ecare.eCare.DTO.CustomerDTO;
import com.t_systems.ecare.eCare.entity.Contract;
import com.t_systems.ecare.eCare.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerConverterImpl implements CustomerConverter{
    @Autowired
    ContractConverter contractConverter;
    @Override
    public Customer converterCustomerDTOToCustomer(CustomerDTO customerDTO) {
        Customer customer=new Customer();
        customer.setId(customerDTO.getCustomerID());
        customer.setName(customerDTO.getCustomerName());
        customer.setBirthDate(customerDTO.getCustomerBirthDate());
        customer.setPassportDetails(customerDTO.getCustomerPassportDetails());
        customer.setAddress(customerDTO.getCustomerAdress());
        customer.setEmail(customerDTO.getCustomerEmail());
        customer.setSurname(customerDTO.getCustomerSurname());
        List<ContractDTO> customerDTOList=customerDTO.getCustomerDTOListContract();        ;
        customer.setContractIdList(customerDTOList.stream().map((s)->
                contractConverter.converterContractDTOToContract(s)).collect(Collectors.toList()));
        return customer;
    }

    @Override
    public CustomerDTO converterCustomerToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO=new CustomerDTO();
        customerDTO.setCustomerID(customer.getId());
        customerDTO.setCustomerAdress(customer.getAddress());
        customerDTO.setCustomerName(customer.getName());
        customerDTO.setCustomerEmail(customer.getEmail());
        customerDTO.setCustomerSurname(customer.getSurname());
        customerDTO.setCustomerBirthDate(customer.getBirthDate());
        customerDTO.setCustomerPassportDetails(customer.getPassportDetails());
        List<Contract> contractList=customer.getContractIdList();
        customerDTO.setCustomerDTOListContract(contractList.stream().
                map(s->contractConverter.convertContractToContractDTO(s)).collect(Collectors.toList()));
        return customerDTO;
    }
}
