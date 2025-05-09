package com.example.demo.application.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.application.services.MenuService;
import com.example.demo.domain.entities.menu.Menu;

@RestController
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menus")
    public Iterable<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/menus/{menuId}")
    public Optional<Menu> getMenuById(@PathVariable String menuId) {
        return menuService.getMenuById(menuId);
    }

    @GetMapping("/menus")
    public Iterable<Menu> getMenusByMenuCategoryId(@RequestParam String menuCategoryId) {
        return menuService.getMenusByMenuCategoryName(menuCategoryId);
    }
}
