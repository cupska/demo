package com.example.demo.application.services;

import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.entities.restaurant.Restaurant;
import com.example.demo.domain.entities.restaurant.RestaurantId;
import com.example.demo.domain.repositories.RestaurantRepository;

public class RestaurantService {
    private final MenuService menuService;
    private final MenuCategoryService menuCategoryService;
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(MenuService menuService, MenuCategoryService menuCategoryService,
            RestaurantRepository restaurantRepository) {
        this.menuService = menuService;
        this.menuCategoryService = menuCategoryService;
        this.restaurantRepository = restaurantRepository;
    }

    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(String restaurantId) {
        RestaurantId n = new RestaurantId(UUID.fromString(restaurantId));

        return restaurantRepository.findById(n);
    }

}
