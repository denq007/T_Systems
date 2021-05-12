package com.t_systems.ecare.eCare.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ContractDTO {
    private int id;
    private String number;
    private int tariffId;
    private int customerId;
    boolean blockedByCustomer;
    boolean blockedByAdmin;
    private Map<String, Integer> allTariffs = new HashMap<>();
    private Map<String, Integer> allOptions = new HashMap<>();
    private Set<Integer> optionsIds = new HashSet<>();
    public ContractDTO(int customerID)
    {
        this.customerId=customerID;
    }
}
