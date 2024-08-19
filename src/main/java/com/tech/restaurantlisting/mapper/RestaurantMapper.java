package com.tech.restaurantlisting.mapper;

import com.tech.restaurantlisting.dto.RestaurantDto;
import com.tech.restaurantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {


    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapToRestaurant(RestaurantDto restaurantDto);

    RestaurantDto mapToRestaurantDto(Restaurant restaurant);
}
