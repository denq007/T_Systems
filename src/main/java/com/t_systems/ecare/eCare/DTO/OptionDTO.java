package com.t_systems.ecare.eCare.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class OptionDTO {
    private int optionId;
    private String optionName;
    private double optionPrice;
    private double optionConnectionCost;
    private int optionGroupNumber;
    private List<TariffDTO> listTariff;
}
