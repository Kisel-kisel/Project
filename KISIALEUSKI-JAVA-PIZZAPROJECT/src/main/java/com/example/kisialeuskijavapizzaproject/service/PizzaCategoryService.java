package com.example.kisialeuskijavapizzaproject.service;
import com.example.kisialeuskijavapizzaproject.entity.Order;
import com.example.kisialeuskijavapizzaproject.entity.PizzaCategory;

import java.util.List;
import java.util.Optional;

public interface PizzaCategoryService {
    List<PizzaCategory> getCategoryPizza();
    Optional<PizzaCategory> findPizzaCategoryById(Integer id);
    boolean deleatePizzaCategory(Integer id);
    void addPizzaCategory(PizzaCategory pizzaCategory);
}
