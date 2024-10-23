package com.example.RestaurantCode.Restaurant.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long MenuId;
    private String name;
    private Double price;
    private Integer availableQuantity;
    private Category category;
}
