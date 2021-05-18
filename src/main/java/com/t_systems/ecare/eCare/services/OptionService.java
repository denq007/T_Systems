package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DTO.OptionDTO;
import com.t_systems.ecare.eCare.DTO.UserDTO;
import com.t_systems.ecare.eCare.entity.Option;
import com.t_systems.ecare.eCare.entity.User;

import java.util.List;
import java.util.Optional;

public interface OptionService {
    Optional<String> saveOption(OptionDTO optionDTO);
    public OptionDTO convertToDto(Option option);
    public Option convertToEntity(OptionDTO optionDTO);

    List<OptionDTO> getAllOptions();
}
