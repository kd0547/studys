package com.example.boardexample.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String orderNumber;

    private String orderDate;

    private String orderStatus;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<OrdersDetails>  ordersDetails = new ArrayList<OrdersDetails>();
}
