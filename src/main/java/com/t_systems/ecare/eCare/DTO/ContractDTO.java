package com.t_systems.ecare.eCare.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ContractDTO {
    private int id;
    private int number;
    private String tariffId;
    private int customerId;
    boolean blockedByCustomer;
    boolean blockedByAdmin;
    private Map<String, Integer> allTariffs = new HashMap<>();

    public ContractDTO(int customerID)
    {
        this.customerId=customerID;
    }
}
