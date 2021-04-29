package com.t_systems.ecare.eCare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToOne(cascade =CascadeType.ALL)//mappedBy = "id",cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH}
    @JoinColumn(name="customer_id")
    private Customer customer;
    @Column(name = "login")
    private String login;
    @Column(name = "passwort")
    private String passwort;
    @Column(name = "blocked")
    boolean blocked;
    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "roles")
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User(String login, String passwort, boolean blocked) {
        this.login = login;
        this.passwort = passwort;
        this.blocked = blocked;
    }
}
