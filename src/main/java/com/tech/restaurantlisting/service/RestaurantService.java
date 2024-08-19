package com.tech.restaurantlisting.service;


import com.tech.restaurantlisting.dto.RestaurantDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantService {

    List<RestaurantDto> fetchAllRestaurants();

    RestaurantDto addRestaurants(RestaurantDto restaurantDto);

    ResponseEntity<RestaurantDto> getRestaurantByCode(String restaurantCode);
}
