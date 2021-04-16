package com.t_systems.ecare.eCare.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String number;
    @OneToOne
    @Column(name = "tarif_id")
    private Tariff tariffId;
    @OneToMany
    @Column(name = "option_id")
    private List<Option> optionId;

    public Contract() {
    }

    public Contract(int id, String number, Tariff tariffId, List<Option> optionId) {
        this.id = id;
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
