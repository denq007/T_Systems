package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DAO.ContractDAO;
import com.t_systems.ecare.eCare.DTO.ContractDTO;
import com.t_systems.ecare.eCare.DTO.CustomerDTO;
import com.t_systems.ecare.eCare.entity.Contract;
import com.t_systems.ecare.eCare.entity.Customer;
import com.t_systems.ecare.eCare.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ContractServiceImp implements ContractService{
    @Autowired
    ContractDAO contractDAO;
    @Autowired
    ModelMapper modelMapper;

    public ContractDTO convertToDto(Contract contract) {
        return modelMapper.map(contract, ContractDTO.class);
    }
    public Contract convertToEntity(ContractDTO contractDTO) {
        Contract contract = modelMapper.map(contractDTO, Contract.class);
        return contract;
    }


    @Override
    public Optional<String> update(ContractDTO dto) {
        Contract contract= contractDAO.findOne(dto.getId());
        Customer customer=contract.getCustomerId();
        contract=convertToEntity(dto);
        contract.setCustomerId(customer);
        contractDAO.update(contract);
        return Optional.empty();
    }

    @Override
    public ContractDTO getDto(int id) {
        return convertToDto(contractDAO.findOne(id));
    }
}
