package com.example.RestaurantCode.Restaurant.Contoller;

import com.example.RestaurantCode.Restaurant.APIRequest.MenuRequest;
import com.example.RestaurantCode.Restaurant.APIRequest.OrderRequest;
import com.example.RestaurantCode.Restaurant.Models.Order;
import com.example.RestaurantCode.Restaurant.Response.ResponseModel;
import com.example.RestaurantCode.Restaurant.Services.MenuServices;
import com.example.RestaurantCode.Restaurant.Services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order/api")
public class OrderController {

    @Autowired
    OrderServices orderServices;
    @PostMapping("/addOrUpdateOrderDetails")
    public ResponseModel<Long> addOrUpdateOrder(@RequestBody OrderRequest request){
        return orderServices.getOrdee(request);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return this.orderServices.getOrderById(id);
    }
}
