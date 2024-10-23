package com.example.RestaurantCode.Restaurant.Repository;

import com.example.RestaurantCode.Restaurant.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderId(Long menuId);
}
