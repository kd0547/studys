package com.example.boardexample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


}
