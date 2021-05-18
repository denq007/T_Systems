package com.t_systems.ecare.eCare.DTO;

import com.t_systems.ecare.eCare.entity.Contract;
import com.t_systems.ecare.eCare.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {
    private int id;
    private UserDTO user;
    private String name;
    private String surname;
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
    private String passportDetails;
    private String address;
    private List<Contract> contractIdList;
    private String email;
}
