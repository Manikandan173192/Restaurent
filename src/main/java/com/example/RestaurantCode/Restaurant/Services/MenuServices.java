package com.example.RestaurantCode.Restaurant.Services;

import com.example.RestaurantCode.Restaurant.APIRequest.MenuRequest;
import com.example.RestaurantCode.Restaurant.Models.Category;
import com.example.RestaurantCode.Restaurant.Models.Menu;
import com.example.RestaurantCode.Restaurant.Repository.MenuRepository;
import com.example.RestaurantCode.Restaurant.Response.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServices {
    @Autowired
    MenuRepository menuRepository;

    public ResponseModel<Long> getMenu(MenuRequest request){
        try{
            List<Menu> menuList = menuRepository.findByMenuId(request.getMenuId());
            var apiAction = 0;
            if (!menuList.isEmpty()){
                menuList.getFirst().setName(request.getName());
                menuList.getFirst().setPrice(request.getPrice());
                menuList.getFirst().setCategory(request.getCategory());
                menuList.getFirst().setAvailableQuantity(request.getAvailableQuantity());
                menuRepository.save(menuList.getFirst());
                apiAction = 1;
            }else{
                var menuLists = new Menu();
                menuLists.setName(request.getName());
                menuLists.setPrice((request.getPrice()));
                menuLists.setCategory(request.getCategory());
                menuLists.setAvailableQuantity(request.getAvailableQuantity());
                menuRepository.save(menuLists);
                apiAction = 2;
            }

            return new ResponseModel<>( apiAction == 2 ?"Menu is added successfully " : "change in Menu is updated successfully ", true, request.getMenuId());
        }
        catch (Exception e){
            return new ResponseModel<>("No record found",false, null);
        }
    }

    public  ResponseModel<List<Menu>> getAllMenu(Optional<Category> category){
        List<Menu> list = category.map(menuRepository :: findByCategory)
                .orElseGet(menuRepository :: findAll);
        return new ResponseModel<>("List of Menu ", true , list);
    }
}

