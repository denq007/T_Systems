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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tariffs_options",joinColumns = @JoinColumn(name="option_id"),
    inverseJoinColumns = @JoinColumn(name = "tariffn_id")
    )
    private List<Tariff> tariff;

}
