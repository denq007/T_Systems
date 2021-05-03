package com.t_systems.ecare.eCare.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {
    private int customerID;
    private String customerName;
    private String customerSurname;
    private LocalDate customerBirthDate;
    private String customerPassportDetails;
    private String customerAdress;
    private String customerEmail;
    private List<ContractDTO> customerDTOListContract;
}
