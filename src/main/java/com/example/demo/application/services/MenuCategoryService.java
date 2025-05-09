package com.example.demo.application.services;

import com.example.demo.domain.entities.menuCategory.MenuCategory;
import com.example.demo.domain.repositories.MenuCategoryRepository;

public class MenuCategoryService {
    private final MenuCategoryRepository menuCategoryRepository;

    public MenuCategoryService(MenuCategoryRepository menuCategoryRepository) {
        this.menuCategoryRepository = menuCategoryRepository;
    }

    public Iterable<MenuCategory> getAllMenuCategories() {
        return menuCategoryRepository.findAll();
    }

}
