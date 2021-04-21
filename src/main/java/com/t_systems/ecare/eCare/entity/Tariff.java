package com.t_systems.ecare.eCare.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tariff")
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
        //TO DO about CascadeType.ALL
    @ManyToMany(cascade=CascadeType.ALL/*{CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH}*/,fetch = FetchType.EAGER)
    @JoinTable(name = "tariff_option", joinColumns = @JoinColumn(name = "tariff_id"),
            inverseJoinColumns =@JoinColumn(name = "option_id"))
    private List<Option> optionIdList;

    public Tariff() {
    }

    public Tariff(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public void addOptionToTariff(Option option)
    {
        if(optionIdList==null)
            optionIdList=new ArrayList<>();
        optionIdList.add(option);

    }
    @Override
    public String toString() {
        return "Tariff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Option> getOptionIdList() {
        return optionIdList;
    }

    public void setOptionIdList(List<Option> optionIdList) {
        this.optionIdList = optionIdList;
    }
}
