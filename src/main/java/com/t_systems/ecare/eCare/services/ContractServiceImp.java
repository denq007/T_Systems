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

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @Autowired
    OptionService optionService;
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
        Tariff tariff = tariffDAO.findOne(dto.getTariffId());
        if(optionService.checkСompatibilityOptions(dto.getOptionsIds(),tariff.getOptionIdList()).isPresent())
        {
            return optionService.checkСompatibilityOptions(dto.getOptionsIds(),tariff.getOptionIdList());
        }
        dto.setAddNameOptions(optionService.deleteOptionsAvailableTariffAnDADDNameOption(dto.getOptionsIds(),tariff.getOptionIdList()));
        Contract contract = contractDAO.findOne(dto.getId());
        Customer customer = contract.getCustomerId();
        contract = convertToEntity(dto);
        contract.setCustomerId(customer);
        contract.setTariffId(tariff);
        contract.setBlockedByUser(dto.isBlockedByUser());
        contract.setBlockedByAdmin(dto.isBlockedByAdmin());
        contract.setAddOptionIdList(dto.getOptionsIds().stream().map(s-> optionDAO.findOne(s)).collect(Collectors.toSet()));
        contractDAO.update(contract);
        return Optional.empty();
    }

    @Override
    @Transactional
    public ContractDTO getDto(int id) {
        Contract contract=contractDAO.findOne(id);
        ContractDTO dto=convertToDto(contract);
        dto.setAddNameOptions(contract.getAddOptionIdList().stream().map(s->s.getName()).collect(Collectors.toSet()));
        return dto;
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
        Tariff tariff = tariffDAO.findOne(contractDTO.getTariffId());
        contract.setTariffId(tariff);
        contract.setBlockedByUser(contractDTO.isBlockedByUser());
        contract.setBlockedByAdmin(contractDTO.isBlockedByAdmin());
        // contract.setCustomerId(customerService.convertToEntity(customerService.findById(contractDTO.getCustomerId())));
        contract.setCustomerId(customerDAO.findOne(contractDTO.getCustomerId()));
        contract.setNumber(contractDTO.getNumber());
        contractDTO.setId(contractDAO.save(contract));
        contractDTO.setTariffName(tariff.getName());
        return Optional.empty();
    }

    @Override
    @Transactional
    public List<ContractDTO> showAllContracts() {
        List<Contract> list=contractDAO.findAll();
        return list.stream().map(s->convertToDto(s)).collect(Collectors.toList());
    }

    @Override
    public boolean isContractBlocked(ContractDTO dto) {
       if(dto.isBlockedByAdmin()||dto.isBlockedByUser())
           return true;
       return false;
    }


}
