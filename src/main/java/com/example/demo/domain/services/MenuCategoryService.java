package com.example.demo.domain.services;

import com.example.demo.domain.repositories.MenuCategoryRepository;

public class MenuCategoryService {
    private final MenuCategoryRepository menuCategoryRepository;

    public MenuCategoryService(MenuCategoryRepository menuCategoryRepository) {
        this.menuCategoryRepository = menuCategoryRepository;
    }

}
