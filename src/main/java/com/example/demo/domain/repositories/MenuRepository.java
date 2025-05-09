package com.example.demo.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.entities.menu.Menu;
import com.example.demo.domain.entities.menu.MenuId;
import com.example.demo.domain.entities.menuCategory.MenuCategoryId;

public interface MenuRepository extends CrudRepository<Menu, MenuId> {

    Iterable<Menu> findByMenuCategoryName(String menuCategoryName);

    Iterable<Menu> findByPriceRange(double minPrice, double maxPrice);

}
