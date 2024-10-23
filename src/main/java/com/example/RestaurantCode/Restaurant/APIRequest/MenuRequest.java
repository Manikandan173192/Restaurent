package com.example.RestaurantCode.Restaurant.APIRequest;

import com.example.RestaurantCode.Restaurant.Models.Category;
import lombok.Data;

@Data
public class MenuRequest {
    private Long menuId;
    private String name;
    private Double price;
    private Integer availableQuantity;
    private Category category;
}
