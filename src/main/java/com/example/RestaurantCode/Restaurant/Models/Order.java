package com.example.RestaurantCode.Restaurant.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;
    private Double totalAmount;
    private String customerName;
    private String customerPhoneNumber;
    private LocalDateTime createdAt;
    private Status status;
    private List<OrderItem> item;
}
