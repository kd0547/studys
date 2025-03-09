package com.example.boardexample.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String description;

    private double price;

    private int stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;


}
