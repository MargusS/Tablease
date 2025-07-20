package com.tablease.menu.domain.factory;

import java.util.List;

import com.tablease.menu.domain.Allergen;
import com.tablease.menu.domain.Dish;
import com.tablease.menu.domain.DishType;
import com.tablease.menu.domain.VO.CostPrice;
import com.tablease.menu.domain.VO.SellingPrice;

public interface DishFactory {
    Dish create(String name, String description, SellingPrice price, CostPrice cost, DishType dishType, List<Allergen> allergens, String thumbnail);
}
