package com.t_systems.ecare.eCare.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "connection_cost")
    private double connectionCost;
    @ManyToMany(cascade = CascadeType.ALL/*{CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH}*/,fetch = FetchType.EAGER)
    @JoinTable(name = "tariff_option",joinColumns = @JoinColumn(name="option_id"),
            inverseJoinColumns = @JoinColumn(name = "tariff_id")
    )
    private List<Tariff> tariffsList;

    public void addTariffToOption(Tariff tariff)
    {
        if(tariffsList==null)
            tariffsList=new ArrayList<>();
        tariffsList.add(tariff);
    }
    public Option() {
    }

    public int getId() {
        return id;
    }

    public Option(String name, double price, double connectionCost) {
        this.name = name;
        this.price = price;
        this.connectionCost = connectionCost;
    }
    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", connectionCost=" + connectionCost +
                '}';
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

    public double getConnectionCost() {
        return connectionCost;
    }

    public void setConnectionCost(double connectionCost) {
        this.connectionCost = connectionCost;
    }

    public List<Tariff> getTariffsList() {
        return tariffsList;
    }

    public void setTariffsList(List<Tariff> tariff) {
        this.tariffsList = tariff;
    }



}
