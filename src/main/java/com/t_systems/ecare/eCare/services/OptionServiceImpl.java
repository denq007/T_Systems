package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DAO.OptionDAO;
import com.t_systems.ecare.eCare.DTO.OptionDTO;
import com.t_systems.ecare.eCare.entity.Option;
import com.t_systems.ecare.eCare.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Access;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OptionServiceImpl implements OptionService{
    @Autowired
    OptionDAO optionDAO;
    @Autowired
    ModelMapper modelMapper;

    @Override
    @Transactional
    public Optional<String> saveOption(OptionDTO optionDTO) {
        Option newOption =optionDAO.findByName(optionDTO.getOptionName());
        if(newOption!=null)
        {
            return Optional.of("This option's name is already registered");
        }
        newOption=convertToEntity(optionDTO);
        optionDAO.save(newOption);
        return Optional.empty();
    }

    @Override
    public OptionDTO convertToDto(Option option) {
        return modelMapper.map(option,OptionDTO.class);
    }

    @Override
    public Option convertToEntity(OptionDTO optionDTO) {
        return modelMapper.map(optionDTO,Option.class);
    }

    @Override
    @Transactional
    public List<OptionDTO> getAllOptions() {
        return optionDAO.findAll().stream().map(s->convertToDto(s)).collect(Collectors.toList());
    }
}
