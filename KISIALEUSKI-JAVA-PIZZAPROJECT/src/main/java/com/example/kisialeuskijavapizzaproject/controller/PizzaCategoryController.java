package com.example.kisialeuskijavapizzaproject.controller;

import com.example.kisialeuskijavapizzaproject.entity.PizzaCategory;
import com.example.kisialeuskijavapizzaproject.service.PizzaCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PizzaCategoryController {

    private final PizzaCategoryService service;

    @GetMapping(value = "/get-all-pizzas")
    public List<PizzaCategory> getAllPizzas() {
        return service.getCategoryPizza();
    }

    @GetMapping(value = "/get-pizza/{id}")
    public Optional<PizzaCategory> getAPizza(@PathVariable(name = "id") Integer id) {
        return service.findPizzaCategoryById(id);
    }

    @DeleteMapping(value = "/delete-pizza/{id}")
    public void deleteAPizza(@PathVariable Integer id) {
        service.deleatePizzaCategory(id);
    }

    @PostMapping(value = "/add-pizza")
    public PizzaCategory addNewPizza(@RequestBody PizzaCategory pizza) {
        service.addPizzaCategory(pizza);
        return pizza;
    }

    @PutMapping(value = "/update-pizza/{id}")
    public void putPizza(@PathVariable(name = "id") Integer id, @RequestBody PizzaCategory pizzaData) {
        pizzaData.setId(id);
        service.addPizzaCategory(pizzaData);
    }
}
