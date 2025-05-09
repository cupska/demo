package com.example.demo.domain.entities.menu;

import java.util.List;

import com.example.demo.domain.entities.menuCategory.MenuCategoryId;

import lombok.Data;

@Data
public class Menu {
    MenuId menuId;
    MenuCategoryId menuCategoryId;
    String name;
    String description;
    float price;
    List<String> imageUrls;
}
