package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DAO.ContractDAO;
import com.t_systems.ecare.eCare.DAO.OptionDAO;
import com.t_systems.ecare.eCare.DAO.TariffDAO;
import com.t_systems.ecare.eCare.DTO.ContractDTO;
import com.t_systems.ecare.eCare.entity.Contract;
import com.t_systems.ecare.eCare.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;
@Service
public class ContractServiceImp implements ContractService{
    @Autowired
    ContractDAO contractDAO;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    OptionDAO optionDAO;
    @Autowired
    TariffDAO tariffDAO;
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
    public Optional<String> update(ContractDTO dto) {
        Contract contract= contractDAO.findOne(dto.getId());
        Customer customer=contract.getCustomerId();
        contract=convertToEntity(dto);
        contract.setCustomerId(customer);
        contractDAO.update(contract);
        return Optional.empty();
    }

    @Override
  //  @Transactional
    public ContractDTO getDto(int id) {
        return convertToDto(contractDAO.findOne(id));
    }
    public void showTariffandOptions(ContractDTO dto) {
        Map<String, Integer> mapOptions = dto.getAllOptions();
        optionDAO.getAllOptionNamesAndIds().forEach(array -> mapOptions.put((String) array[1], (Integer) array[0]));
        Map<String, Integer> mapTariffs = dto.getAllTariffs();
        tariffDAO.getAllTariffNamesAndIds().forEach(array -> mapTariffs.put((String) array[1], (Integer) array[0]));
    }
}
