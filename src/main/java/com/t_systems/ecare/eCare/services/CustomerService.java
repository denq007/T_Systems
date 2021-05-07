package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DTO.CustomerDTO;
import com.t_systems.ecare.eCare.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public CustomerDTO getCustomerDTOwithoutContractsByEmailUser(String username);
    public Optional<String> update(CustomerDTO dto);

}
