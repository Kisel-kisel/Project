package com.example.kisialeuskijavapizzaproject.controller;

import com.example.kisialeuskijavapizzaproject.service.AboutPersons;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class AboutPersonController {

    private final AboutPersons about;

    @GetMapping(value = "/persons-pizzas/{id}")
    public List<String> personsPizzas(@PathVariable(name = "id") Integer id) {
        return about.getPizzaPersonLike(id);
    }

    @GetMapping(value = "/persons-cafes/{id}")
    public List<String> personsCafes(@PathVariable(name = "id") Integer id) {
        return about.getCafePersonLike(id);
    }

    @GetMapping(value = "/persons-money/{id}")
    public Integer personsMoney(@PathVariable(name = "id") Integer id) {
        return about.getPersonMoney(id);
    }

    @GetMapping(value = "/count_of_orders/{id}")
    public Integer countPersonOrders(@PathVariable(name = "id") Integer id){
        return about.getCountOfOrders(id);
    }
}
