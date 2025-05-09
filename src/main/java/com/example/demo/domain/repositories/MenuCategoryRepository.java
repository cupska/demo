package com.example.demo.domain.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.entities.menuCategory.MenuCategory;
import com.example.demo.domain.entities.menuCategory.MenuCategoryId;

public interface MenuCategoryRepository extends CrudRepository<MenuCategory, MenuCategoryId> {

    Optional<MenuCategory> findFirstByName(String name);

}