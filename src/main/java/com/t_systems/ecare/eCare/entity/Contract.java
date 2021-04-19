package com.t_systems.ecare.eCare.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "сontract")
public class Contract {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "number")
    private String number;
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "tariff_id",referencedColumnName = "id")
    private Tariff tariffId;
    @OneToMany(mappedBy ="id" )
    @Column(name = "option_id")
    private List<Option> optionId;

    public Contract() {
    }

    public Contract( String number, Tariff tariffId, List<Option> optionId) {
        this.number = number;
        this.tariffId = tariffId;
        this.optionId = optionId;
    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Tariff getTariffId() {
        return tariffId;
    }

    public void setTariffId(Tariff tariffId) {
        this.tariffId = tariffId;
    }

    public List<Option> getOptionId() {
        return optionId;
    }

    public void setOptionId(List<Option> optionId) {
        this.optionId = optionId;
    }




}
