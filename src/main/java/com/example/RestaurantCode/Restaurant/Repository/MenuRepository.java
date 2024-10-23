package com.example.RestaurantCode.Restaurant.Repository;

import com.example.RestaurantCode.Restaurant.Models.Category;
import com.example.RestaurantCode.Restaurant.Models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByMenuId(Long id);

    List<Menu> findByNameAndPriceAndAvailableQuantityAndCategory(String name, Double price, Integer availableQuantity, Category category);

    List<Menu> findByCategory(Category category);
}
