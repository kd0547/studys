package com.example.boardexample.entity;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String address;

    private String imageUrl;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Orders> orders;

    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userCard_id")
    private UserCart userCart;
}
