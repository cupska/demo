package com.example.demo.domain.services;

import org.checkerframework.checker.units.qual.t;

import com.example.demo.domain.entities.menuCategory.MenuCategory;
import com.example.demo.domain.repositories.MenuCategoryRepository;

public class MenuService {
    private final MenuCategoryRepository menuCategoryRepository;

    public MenuService(MenuCategoryRepository menuCategoryRepository) {
        this.menuCategoryRepository = menuCategoryRepository;
    }

    public void getMenusByMenuCategoryName(String menuCategoryName) {
        if (!menuCategoryRepository.findFirstByName(menuCategoryName).isPresent()) {
            throw new IllegalArgumentException("Menu category not found: " + menuCategoryName);
        }
    }
}
