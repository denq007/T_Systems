package com.t_systems.ecare.eCare.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class TariffDTO {
    private int tariffID;
    private String tariffName;
    private double tariffPrice;
    boolean tariffCheckOld;
    private Set<Integer> tariffOption;
    private Map<String, Integer> allOptions = new HashMap<>();
    private List<String> optionName=new ArrayList<>();

}
