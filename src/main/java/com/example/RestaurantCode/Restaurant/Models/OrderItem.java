package com.example.RestaurantCode.Restaurant.Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class OrderItem {
    private Menu menuItem;
    private Integer quantity;
    private Double subTotal;
}
