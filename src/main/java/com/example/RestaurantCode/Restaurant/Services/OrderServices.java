package com.example.RestaurantCode.Restaurant.Services;

import com.example.RestaurantCode.Restaurant.APIRequest.MenuRequest;
import com.example.RestaurantCode.Restaurant.APIRequest.OrderRequest;
import com.example.RestaurantCode.Restaurant.Models.Category;
import com.example.RestaurantCode.Restaurant.Models.Menu;
import com.example.RestaurantCode.Restaurant.Models.Order;
import com.example.RestaurantCode.Restaurant.Repository.OrderRepository;
import com.example.RestaurantCode.Restaurant.Response.ResponseModel;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServices {

    @Autowired
    OrderRepository orderRepository;
    public ResponseModel<Long> getOrdee(OrderRequest request){
        try{
            List<Order> ordeList = orderRepository.findByOrderId(request.getOrderId());
            var apiAction = 0;
            if (!ordeList.isEmpty()){
                ordeList.getFirst().setCustomerName(request.getCustomerName());
                //ordeList.getFirst().setTotalAmount(request.getTotalAmount());
                ordeList.getFirst().setCustomerPhoneNumber(request.getCustomerPhoneNumber());
                ordeList.getFirst().setCreatedAt(LocalDateTime.now());
                orderRepository.save(ordeList.getFirst());
                apiAction = 1;
            }else{
                var orderLists = new Order();
                orderLists.setCustomerName(request.getCustomerName());
                orderLists.setCustomerPhoneNumber((request.getCustomerPhoneNumber()));
                orderLists.setCreatedAt(LocalDateTime.now());

                orderRepository.save(orderLists);
                apiAction = 2;
            }

            return new ResponseModel<>( apiAction == 2 ? "Menu is added successfully " : "change in Menu is updated successfully ", true, request.getOrderId());
        }
        catch (Exception e){
            return new ResponseModel<>("No record found",false, null);
        }
    }

//    public ResponseModel<List<Order>> list(String customerName,String customerPhoneNumber,Integer availableQuantity, Category category){
//        List<Menu> result = menuRepository.findByNameAndPriceAndAvailableQuantityAndCategory(name,price,availableQuantity,category);
//        if (!result.isEmpty()){
//            return new ResponseModel<>( "The list Of Menu ", true, result);
//        }else {
//            return new ResponseModel<>("Menu list is Empty", false, null);
//        }
//    }

    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order not found"));
    }
}
