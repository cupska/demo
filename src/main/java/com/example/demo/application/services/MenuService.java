package com.example.demo.application.services;

import java.util.Optional;

import com.example.demo.domain.entities.menu.Menu;
import com.example.demo.domain.entities.menu.MenuId;
import com.example.demo.domain.entities.menuCategory.MenuCategoryId;
import com.example.demo.domain.repositories.MenuRepository;

public class MenuService {
    private final MenuRepository menuRepository;
    private final com.example.demo.domain.services.MenuService menuService;

    public MenuService(MenuRepository menuRepository, com.example.demo.domain.services.MenuService menuService) {
        this.menuRepository = menuRepository;
        this.menuService = menuService;
    }

    public Iterable<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuById(String menuId) {
        MenuId n = new MenuId();
        n.setId(Long.parseLong(menuId));

        return menuRepository.findById(n);
    }

    public Iterable<Menu> getMenusByMenuCategoryName(String menuCategoryName) {
        menuService.getMenusByMenuCategoryName(menuCategoryName);

        return menuRepository.findByMenuCategoryName(menuCategoryName);
    }
}
