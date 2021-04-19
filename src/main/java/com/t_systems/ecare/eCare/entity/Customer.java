package com.t_systems.ecare.eCare.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
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
    private LocalDate birthDate;
    @Column(name="passport_details")
    private String passportDetails;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "id")
    @Column(name = "contract_id")
    private List<Contract> contractId;
    @Column(name = "email")
    private String email;
    @Column(name = "customer_password")
    //TO DO add dependens after add table for security
    private String password;
    @Column(name = "enabled")
    boolean check;
    public Customer() {
    }

    public Customer(String name, String surname, LocalDate birthDate, String passportDetails, String address, List<Contract> contractId, String email, String password, boolean check) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.passportDetails = passportDetails;
        this.address = address;
        this.contractId = contractId;
        this.email = email;
        this.password = password;
        this.check = check;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassportDetails() {
        return passportDetails;
    }

    public void setPassportDetails(String passportDetails) {
        this.passportDetails = passportDetails;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Contract> getContractId() {
        return contractId;
    }

    public void setContractId(List<Contract> contractId) {
        this.contractId = contractId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }





}
