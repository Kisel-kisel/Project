package com.example.kisialeuskijavapizzaproject.service;

import com.example.kisialeuskijavapizzaproject.entity.QuantityPizza;

import java.util.List;

public interface QuantityPizzaService {
    List<QuantityPizza> findQuantityPizzaById(Integer pizzaId);
}
