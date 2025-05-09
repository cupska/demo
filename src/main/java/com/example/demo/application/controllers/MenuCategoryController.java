package com.example.demo.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.services.MenuCategoryService;
import com.example.demo.domain.entities.menuCategory.MenuCategory;

@RestController
public class MenuCategoryController {
    private final MenuCategoryService menuCategoryService;

    public MenuCategoryController(MenuCategoryService menuCategoryService) {
        this.menuCategoryService = menuCategoryService;
    }

    @GetMapping("/categories")
    public Iterable<MenuCategory> getAllMenuCategories() {
        return menuCategoryService.getAllMenuCategories();
    }

}
