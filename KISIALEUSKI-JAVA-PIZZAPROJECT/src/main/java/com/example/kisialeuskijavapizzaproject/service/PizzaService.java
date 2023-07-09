package com.example.kisialeuskijavapizzaproject.service;

import com.example.kisialeuskijavapizzaproject.entity.Pizza;

public interface PizzaService {

    /**
     * adds pizza to the cafe and subtracts the amount of food spent
     *
     * @param pizza shows how many pizzas we added in cafe
     */
    void addPizza(Pizza pizza);
}
