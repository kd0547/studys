package com.example.boardexample.dto;

import com.example.boardexample.entity.Category;
import com.example.boardexample.entity.Product;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class ProductDto {
    private int id;

    private String name;

    private String description;

    private double price;

    private Category category;

    public ProductDto (){

    }
    public ProductDto (int id,String name,String description,double price ,Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }


    public static ProductDto createProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory()
        );
    }

}
