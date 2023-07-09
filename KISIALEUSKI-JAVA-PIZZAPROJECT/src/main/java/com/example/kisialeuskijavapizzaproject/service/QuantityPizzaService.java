package com.example.kisialeuskijavapizzaproject.service;

import com.example.kisialeuskijavapizzaproject.entity.QuantityPizza;

import java.util.List;

public interface QuantityPizzaService {

    /**
     * Shows the required amount of pizza ingredients
     *
     * @param pizzaId a certain category of pizza
     *
     * @return required amount of pizza ingredients
     */
    List<QuantityPizza> findQuantityPizzaById(Integer pizzaId);
}
