package com.t_systems.ecare.eCare.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tariff")
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private double price;
        //TO DO about CascadeType.ALL
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tariff_option", joinColumns = @JoinColumn(name = "tariff_id"),
            inverseJoinColumns =@JoinColumn(name = "option_id"))
    private List<Option> optionId;

    public Tariff() {
    }

    public Tariff(String name, double price, List<Option> optionId) {
        this.name = name;
        this.price = price;
        this.optionId = optionId;
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

    public List<Option> getOptionId() {
        return optionId;
    }

    public void setOptionId(List<Option> optionId) {
        this.optionId = optionId;
    }
}
