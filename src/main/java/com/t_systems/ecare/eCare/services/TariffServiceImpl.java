package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DAO.OptionDAO;
import com.t_systems.ecare.eCare.DAO.TariffDAO;
import com.t_systems.ecare.eCare.DTO.RequiredOptionDTO;
import com.t_systems.ecare.eCare.DTO.TariffDTO;
import com.t_systems.ecare.eCare.entity.Option;
import com.t_systems.ecare.eCare.entity.Tariff;
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
    @Autowired
    RequiredOptionServiceImpl requiredOptionService;


    @Override
    public TariffDTO convertToDto(Tariff tariff) {
        TariffDTO tariffDTO=new TariffDTO();
        tariffDTO.setId(tariff.getId());
        tariffDTO.setName(tariff.getName());
        tariffDTO.setPrice(tariffDTO.getPrice());
        tariffDTO.setOld(tariff.isOld());
        tariffDTO.setOptionName(tariff.getOptionIdList().stream().map(s->s.getName()).collect(Collectors.toList()));
        tariffDTO.setTariffOption(tariff.getOptionIdList().stream().map(s->s.getNumberGroup()).collect(Collectors.toSet()));
        tariffDTO.setRequiredOption( showAllRequiredOptions(tariffDTO.getTariffOption()));
        return tariffDTO;
    }

    @Override
    public void showAllOptions(TariffDTO tariffDTO) {
        Map<String, Integer> mapOptions = tariffDTO.getAllOptions();
        optionDAO.getAllOptionNamesAndIds().forEach(array -> mapOptions.put((String) array[1], (Integer) array[0]));
    }
    @Override
    public List<String> showAllRequiredOptions(Set<Integer> tariffOption) {
        List<String> list = new ArrayList<>();
        Set<Integer> set = tariffOption;
        Map<Integer, List<RequiredOptionDTO>> map=requiredOptionService.findAllRequiredOption();
        for (Integer i : set) {
            if (map.containsKey(i)) {
                List<RequiredOptionDTO> listRequired = map.get(i);
                for (int j = 0; j < listRequired.size(); j++) {
                    list.add(listRequired.get(j).getName());
                }
            }
        }
        return list;
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
    @Transactional
    public List<TariffDTO> showAllTariffs() {
       return tariffDAO.findAll().stream().map(s->convertToDto(s)).collect(Collectors.toList());
    }

    @Override
    public Optional<String> update(TariffDTO tariffDTO) {
        Tariff tariff=tariffDAO.findOne(tariffDTO.getId());
        tariff=convertToEntity(tariffDTO);
        tariff.setOptionIdList(getOptionsById((tariffDTO.getTariffOption()).stream().collect(Collectors.toList())));
        tariffDAO.update(tariff);
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
        Tariff newTariff=tariffDAO.findByName(tariffDTO.getName());
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
