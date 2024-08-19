package com.tech.restaurantlisting.controller;

import com.tech.restaurantlisting.dto.RestaurantDto;
import com.tech.restaurantlisting.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@AllArgsConstructor
@CrossOrigin("*")
public class RestaurantController {


    private RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        return new ResponseEntity<>(restaurantService.fetchAllRestaurants(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        RestaurantDto addedRestaurant = restaurantService.addRestaurants(restaurantDto);
        return new ResponseEntity<>(addedRestaurant, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurant/{restaurantCode}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable String restaurantCode) {
        return restaurantService.getRestaurantByCode(restaurantCode);
    }
}
