package com.example.demo.domain.entities.menuCategory;

import lombok.Data;

@Data
public class MenuCategory {
    MenuCategoryId menuCategoryId;
    String name;
    String description;
}
