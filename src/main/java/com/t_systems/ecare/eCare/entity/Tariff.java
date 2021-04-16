package com.t_systems.ecare.eCare.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tariffs")
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
    @JoinTable(name = "tariffs_options", joinColumns = @JoinColumn(name = "tariff_id"),
            inverseJoinColumns =@JoinColumn(name = "toption_id"))
    private List<Option> optionId;
}
