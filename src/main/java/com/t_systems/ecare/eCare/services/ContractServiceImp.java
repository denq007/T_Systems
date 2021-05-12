package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DAO.*;
import com.t_systems.ecare.eCare.DTO.ContractDTO;
import com.t_systems.ecare.eCare.entity.Contract;
import com.t_systems.ecare.eCare.entity.Customer;
import com.t_systems.ecare.eCare.entity.Tariff;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
public class ContractServiceImp implements ContractService {
    @Autowired
    ContractDAOImpl contractDAO;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    OptionDAO optionDAO;
    @Autowired
    TariffDAO tariffDAO;
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerDAOImpl customerDAO;
    @Autowired
    PhoneNumberDAO phoneNumberDAO;
    @Override
    public ContractDTO convertToDto(Contract contract) {
        return modelMapper.map(contract, ContractDTO.class);
    }

    @Override
    public Contract convertToEntity(ContractDTO contractDTO) {
        Contract contract = modelMapper.map(contractDTO, Contract.class);
        return contract;
    }

    @Override
    @Transactional
    public Optional<String> update(ContractDTO dto) {
        Contract contract = contractDAO.findOne(dto.getId());
        Customer customer = contract.getCustomerId();
        contract = convertToEntity(dto);
        contract.setCustomerId(customer);
        Tariff tariff = tariffDAO.findOne(dto.getTariffId());
        contract.setTariffId(tariff);
        contract.setBlockedByUser(dto.isBlockedByCustomer());
        contract.setBlockedByAdmin(dto.isBlockedByAdmin());
        contractDAO.update(contract);
        return Optional.empty();
    }

    @Override
    @Transactional
    public ContractDTO getDto(int id) {
        return convertToDto(contractDAO.findOne(id));
    }

    public void showTariffandOptions(ContractDTO dto) {
        Map<String, Integer> mapOptions = dto.getAllOptions();
        optionDAO.getAllOptionNamesAndIds().forEach(array -> mapOptions.put((String) array[1], (Integer) array[0]));
        Map<String, Integer> mapTariffs = dto.getAllTariffs();
        tariffDAO.getAllTariffNamesAndIds().forEach(array -> mapTariffs.put((String) array[1], (Integer) array[0]));
    }

    @Override
    @Transactional
    public Optional<String> create(ContractDTO contractDTO) {
        Contract contract = new Contract();
        int id=contractDTO.getTariffId();
        Tariff tariff = tariffDAO.findOne(id);
        contract.setTariffId(tariff);
        contract.setBlockedByUser(contractDTO.isBlockedByCustomer());
        contract.setBlockedByAdmin(contractDTO.isBlockedByAdmin());
        // contract.setCustomerId(customerService.convertToEntity(customerService.findById(contractDTO.getCustomerId())));
        contract.setCustomerId(customerDAO.findOne(contractDTO.getCustomerId()));
        contract.setNumber(contractDTO.getNumber());
        contractDTO.setId(contractDAO.save(contract));
        return Optional.empty();
    }


}
