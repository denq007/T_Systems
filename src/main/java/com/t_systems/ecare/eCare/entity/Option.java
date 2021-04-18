package com.t_systems.ecare.eCare.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private double price;
    @Column(name = "connection_cost")
    private double connectionCost;

    public Option() {
    }

    public int getId() {
        return id;
    }

    public Option(String name, double price, double connectionCost, List<Tariff> tariff) {
        this.name = name;
        this.price = price;
        this.connectionCost = connectionCost;
        this.tariff = tariff;
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

    public List<Tariff> getTariff() {
        return tariff;
    }

    public void setTariff(List<Tariff> tariff) {
        this.tariff = tariff;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tariffs_options",joinColumns = @JoinColumn(name="option_id"),
    inverseJoinColumns = @JoinColumn(name = "tariffn_id")
    )
    private List<Tariff> tariff;

}
