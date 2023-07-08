package com.example.kisialeuskijavapizzaproject.controller;

import com.example.kisialeuskijavapizzaproject.entity.PizzaCategory;
import com.example.kisialeuskijavapizzaproject.service.PizzaCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PizzaCategoryController {

    private final PizzaCategoryService service;

    @GetMapping(value = "/get-all-pizzas")
    public ResponseEntity<List<PizzaCategory>> getAllPizzas() {
        List<PizzaCategory> pizzaCategories = service.getCategoryPizza();
        return pizzaCategories != null ? ResponseEntity.ok(pizzaCategories) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/get-pizza/{id}")
    public ResponseEntity<?> getAPizza(@PathVariable(name = "id") Integer id) {
        Optional<PizzaCategory> optionalPizzaCategory =service.findPizzaCategoryById(id);
        return optionalPizzaCategory != null ? ResponseEntity.ok(optionalPizzaCategory) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/delete-pizza/{id}")
    public ResponseEntity<String> deleteAPizza(@PathVariable Integer id) {
        boolean deleted = service.deleatePizzaCategory(id);
        return deleted ? ResponseEntity.ok("Cafe with ID " + id + " deleted successfully") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cafe with ID " + id + " not found");
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
