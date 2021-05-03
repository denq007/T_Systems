package com.t_systems.ecare.eCare.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContractDTO {
    private int contractId;
    private String contractNumber;
    private TariffDTO tariffDTO;
    private CustomerDTO customerDTO;
    boolean blockedByCustomer;
    boolean blockedByAdmin;
}
