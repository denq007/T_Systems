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
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH},fetch = FetchType.EAGER)
    @JoinColumn(name = "tariff_id",referencedColumnName = "id")
    private Tariff tariffId;

    public Contract() {
    }

    public Contract( String number, Tariff tariffId) {
        this.number = number;
        this.tariffId = tariffId;
    }
  /*  public void addOptionToContract(Option option)
    {
        if(optionIdList==null)
            optionIdList=new ArrayList<>();
        optionIdList.add(option);

    }*/

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", tariffId=" + tariffId +
                '}';
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

    /*public List<Option> getOptionIdList() {
        return optionIdList;
    }

    public void setOptionIdList(List<Option> optionId) {
        this.optionIdList = optionId;
    }
*/



}
