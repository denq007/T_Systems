package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DAO.OptionDAO;
import com.t_systems.ecare.eCare.DAO.TariffDAO;
import com.t_systems.ecare.eCare.DTO.TariffDTO;
import com.t_systems.ecare.eCare.DTO.UserDTO;
import com.t_systems.ecare.eCare.entity.Tariff;
import com.t_systems.ecare.eCare.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TariffServiceImpl implements TariffService{
    @Autowired
    TariffDAO tariffDAO;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    OptionDAO optionDAO;

    @Override
    public TariffDTO convertToDto(Tariff tariff) {
        return modelMapper.map(tariff, TariffDTO.class);
    }

    @Override
    public void showAllOptions(TariffDTO tariffDTO) {
        Map<String, Integer> mapOptions = tariffDTO.getAllOptions();
        optionDAO.getAllOptionNamesAndIds().forEach(array -> mapOptions.put((String) array[1], (Integer) array[0]));
    }

    @Override
    @Transactional
    public TariffDTO findTariffByName(String name) {
       return convertToDto(tariffDAO.findByName(name));
    }

    @Override
    public Tariff convertToEntity(TariffDTO tariffDTO) {
        Tariff tariff= modelMapper.map(tariffDTO, Tariff.class);
        return tariff;
    }
    @Override
    @Transactional
    public Optional<String> saveTariff(TariffDTO tariffDTO) {
        Tariff newTariff=tariffDAO.findByName(tariffDTO.getTariffName());
            if(newTariff !=null)
            {
                return Optional.of("This tariff's name is already exist");
            }
            newTariff=convertToEntity(tariffDTO);
            tariffDAO.save(newTariff);
       return Optional.empty();
    }

}
