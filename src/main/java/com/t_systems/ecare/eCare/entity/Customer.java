package com.t_systems.ecare.eCare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name="birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @Column(name="passport_details")
    private String passportDetails;
    @Column(name = "address")
    private String address;
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH},mappedBy = "id")
    private List<Contract> contractIdList;
    @Column(name = "email")
    private String email;
    @Column(name = "customer_password")
    //TO DO add dependens after add table for security
    private String password;
    @Column(name = "enabled")
    private int check;

    public Customer(String name, String surname, LocalDate birthDate, String passportDetails, String address, String email, String password, int check) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.passportDetails = passportDetails;
        this.address = address;
        this.email = email;
        this.password = password;
        this.check = check;
    }


    public void addContractToCustumer(Contract contract)
    {
        if(contractIdList==null)
            contractIdList=new ArrayList<>();
        contractIdList.add(contract);
        contract.setCustomerId(this);
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", passportDetails='" + passportDetails + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", check=" + check +
                '}';
    }
}
