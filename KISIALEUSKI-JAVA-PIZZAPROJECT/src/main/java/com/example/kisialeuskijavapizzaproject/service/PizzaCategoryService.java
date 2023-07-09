package com.example.kisialeuskijavapizzaproject.service;
import com.example.kisialeuskijavapizzaproject.entity.Order;
import com.example.kisialeuskijavapizzaproject.entity.PizzaCategory;

import java.util.List;
import java.util.Optional;

public interface PizzaCategoryService {

    /**
     * Shows all category of pizza
     *
     * @return all category of pizza
     */
    List<PizzaCategory> getCategoryPizza();
    /**
     * Shows selected category of pizza
     *
     * @param id id of a category of pizza
     *
     * @return selected category of pizza
     */
    Optional<PizzaCategory> findPizzaCategoryById(Integer id);
    /**
     * Delete a category of pizza by id
     *
     * @param id id of a category of pizza
     *
     * @return is deleted category of pizza or not
     */
    boolean deleatePizzaCategory(Integer id);
    /**
     * Add new category of pizza
     *
     * @param pizzaCategory parameters of new category of pizza
     */
    void addPizzaCategory(PizzaCategory pizzaCategory);
}
