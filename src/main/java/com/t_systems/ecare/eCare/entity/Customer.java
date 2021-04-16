package com.t_systems.ecare.eCare.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name="birth_date")
    private LocalDateTime birthDate;
    @Column(name="passport_details")
    private String passportDetails;
    @Column(name = "adress")
    private String adress;
    @OneToMany
    @Column(name = "contract_id")
    private List<Contract> contractId;
    @Column(name = "email")
    private String email;
    @Column(name = "customer_password")
    //TO DO add dependens after add table for security
    private String password;
    @Column(name = "enabled")
    boolean check;



}
