package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DAO.OptionDAO;
import com.t_systems.ecare.eCare.DAO.TariffDAO;
import com.t_systems.ecare.eCare.DTO.TariffDTO;
import com.t_systems.ecare.eCare.DTO.UserDTO;
import com.t_systems.ecare.eCare.entity.Option;
import com.t_systems.ecare.eCare.entity.Tariff;
import com.t_systems.ecare.eCare.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

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
        TariffDTO tariffDTO=new TariffDTO();
        tariffDTO.setTariffID(tariff.getId());
        tariffDTO.setTariffName(tariff.getName());
        tariffDTO.setTariffPrice(tariffDTO.getTariffPrice());
        tariffDTO.setTariffCheckOld(tariff.isOld());
        tariffDTO.setOptionName(tariff.getOptionIdList().stream().map(s->s.getName()).collect(Collectors.toList()));

        return tariffDTO;
    }

    @Override
    public void showAllOptions(TariffDTO tariffDTO) {
        Map<String, Integer> mapOptions = tariffDTO.getAllOptions();
        optionDAO.getAllOptionNamesAndIds().forEach(array -> mapOptions.put((String) array[1], (Integer) array[0]));
    }

    @Override
    @Transactional
    public TariffDTO findTariffByName(String name) {
      try {
          Tariff tariff = tariffDAO.findByName(name);
          return convertToDto(tariff);
      }catch (NullPointerException e)
      {
          return null;
      }

    }

    @Override
    @Transactional
    public Optional<String> deleteTariff(String name) {
        Tariff tariff=tariffDAO.findByName(name);
        if(tariff==null)
        {
            return Optional.of("tariff not found");
        }
        if (tariffDAO.isUsed(tariff.getId())) {
            return Optional.of("tariff is used in some contracts");
        }
       tariffDAO.delete(tariff);

        return Optional.empty();
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
            newTariff.setOptionIdList(getOptionsById((tariffDTO.getTariffOption()).stream().collect(Collectors.toList())));
            tariffDAO.save(newTariff);
            tariffDTO.setOptionName(newTariff.getOptionIdList().stream().map(s->s.getName()).collect(Collectors.toList()));
       return Optional.empty();
    }

    private List<Option> getOptionsById(List<Integer> listId)
    {
        List<Option> listOption=new ArrayList<>();
        for (int a:listId
             ) {
            listOption.add(optionDAO.findOne(a));
        }
        return  listOption;
    }

}
