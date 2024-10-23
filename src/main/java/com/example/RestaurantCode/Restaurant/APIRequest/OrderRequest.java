package com.example.RestaurantCode.Restaurant.APIRequest;

import com.example.RestaurantCode.Restaurant.Models.Status;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class OrderRequest {
    private Long orderId;
    private Double totalAmount;
    private String customerName;
    private String customerPhoneNumber;
    private LocalDateTime createdAt;
    private Status status;
}
