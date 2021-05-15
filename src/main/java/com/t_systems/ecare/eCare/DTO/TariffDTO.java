package com.t_systems.ecare.eCare.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class TariffDTO {
    private int tariffID;
    private String tariffName;
    private double tariffPrice;
    boolean tariffCheckOld;
    private List<OptionDTO> tariffOption;
    private Map<String, Integer> allOptions = new HashMap<>();
}
