package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.entity.QuantityPizza;
import com.example.kisialeuskijavapizzaproject.repositaries.QuantityPizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityPizzaService implements com.example.kisialeuskijavapizzaproject.service.QuantityPizzaService {

    @Autowired
    private QuantityPizzaRepository quantityPizzaRepository;

    @Override
    public List<QuantityPizza> findQuantityPizzaById(Integer pizzaId){
        return quantityPizzaRepository.findPizzaById(pizzaId);
    }
}
