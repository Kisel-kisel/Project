package com.example.kisialeuskijavapizzaproject.controller;
import com.example.kisialeuskijavapizzaproject.entity.Cafe;
import com.example.kisialeuskijavapizzaproject.entity.Pizza;
import com.example.kisialeuskijavapizzaproject.repositaries.PizzaRepository;
import com.example.kisialeuskijavapizzaproject.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaService service;
    @PostMapping(value = "/update_count")
    public Pizza updateCount(@RequestBody Pizza pizza) {
        service.addPizza(pizza);
        return pizza;
    }

    @PutMapping(value = "/update-pizzas/{id}")
    public void putPizza(@PathVariable(name = "id") Integer id, @RequestBody Pizza pizzaData) {
        pizzaData.setId(id);
        service.addPizza(pizzaData);
    }
}

