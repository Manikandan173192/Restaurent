package com.example.RestaurantCode.Restaurant.Contoller;

import com.example.RestaurantCode.Restaurant.APIRequest.MenuRequest;
import com.example.RestaurantCode.Restaurant.Models.Category;
import com.example.RestaurantCode.Restaurant.Models.Menu;
import com.example.RestaurantCode.Restaurant.Response.ResponseModel;
import com.example.RestaurantCode.Restaurant.Services.MenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rest/api")
public class MenuController {

    @Autowired
    MenuServices menuServices;
    @PostMapping("/addOrUpdateMenuDetails")
    public ResponseModel<Long> addOrUpdateMenu(@RequestBody MenuRequest request){
        return menuServices.getMenu(request);
    }

    @GetMapping("/getMenuDetails")
    public ResponseModel<List<Menu>> getMenu(@RequestParam(required = false) Category  category){
        return this.menuServices.getAllMenu(Optional.ofNullable(category));
    }
}
