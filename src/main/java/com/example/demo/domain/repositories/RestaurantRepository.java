package com.example.demo.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.entities.restaurant.Restaurant;
import com.example.demo.domain.entities.restaurant.RestaurantId;
import com.example.demo.domain.valueObjects.Location;

public interface RestaurantRepository extends CrudRepository<Restaurant, RestaurantId> {

    Iterable<Restaurant> findByLocation(Location location);

    Iterable<Restaurant> findByCuisineType(String cuisineType);

    Iterable<Restaurant> findByRating(double minRating, double maxRating);
}