package com.t_systems.ecare.eCare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
@Getter
@Setter
@Entity
@NoArgsConstructor
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
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH},fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customerId;

    public Contract(String number, Tariff tariffId, Customer customerId) {
        this.number = number;
        this.tariffId = tariffId;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", tariffId=" + tariffId +
                '}';
    }

}
