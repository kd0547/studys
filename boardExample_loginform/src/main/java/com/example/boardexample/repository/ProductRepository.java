package com.example.boardexample.repository;

import com.example.boardexample.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {


    @PersistenceContext
    private EntityManager em;


    public List<Product> findProducts() {
        return em.createQuery("select p from Product p",Product.class)
                .setMaxResults(20)
                .setFirstResult(0)
                .getResultList();
    }
}
