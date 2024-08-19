package com.tech.restaurantlisting.service;

import com.tech.restaurantlisting.dto.RestaurantDto;
import com.tech.restaurantlisting.entity.Restaurant;
import com.tech.restaurantlisting.mapper.RestaurantMapper;
import com.tech.restaurantlisting.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantDto> fetchAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantDto> restaurantsDtoList = restaurants.stream()
                .map(restaurant -> RestaurantMapper.INSTANCE.mapToRestaurantDto(restaurant))
                .collect(Collectors.toList());
        return restaurantsDtoList;
    }

    @Override
    public RestaurantDto addRestaurants(RestaurantDto restaurantDto) {
        Restaurant savedRestaurant = restaurantRepository.save(RestaurantMapper.INSTANCE.mapToRestaurant(restaurantDto));
        return RestaurantMapper.INSTANCE.mapToRestaurantDto(savedRestaurant);
    }

    @Override
    public ResponseEntity<RestaurantDto> getRestaurantByCode(String restaurantCode) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findByRestaurantCode(restaurantCode);
        if (optionalRestaurant.isPresent()) {
            return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapToRestaurantDto(optionalRestaurant.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
