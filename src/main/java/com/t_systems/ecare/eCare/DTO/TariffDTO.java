package com.t_systems.ecare.eCare.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class TariffDTO {
    private int id;
    private String name;
    private double price;
    boolean isOld;
    private Set<Integer> tariffOption;
    private Map<String, Integer> allOptions = new HashMap<>();
    private List<String> optionName=new ArrayList<>();
    private List<String> requiredOption;
    

}
