package com.example.boardexample.entity;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String address;

    private String imageUrl;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Orders> orders;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private LocalDateTime accessAt;

    private String status;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "userCard_id")
    private UserCart userCart;
}
