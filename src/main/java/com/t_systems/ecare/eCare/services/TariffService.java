package com.t_systems.ecare.eCare.services;

import com.t_systems.ecare.eCare.DTO.TariffDTO;
import com.t_systems.ecare.eCare.entity.Tariff;

import java.util.Optional;

public interface TariffService {
    public Optional<String> saveTariff(TariffDTO tariffDTO);
    public Tariff convertToEntity(TariffDTO tariffDTO);
    public TariffDTO convertToDto(Tariff tariff);

    void showAllOptions(TariffDTO tariffDTO);

    public TariffDTO findTariffByName(String name);
}
