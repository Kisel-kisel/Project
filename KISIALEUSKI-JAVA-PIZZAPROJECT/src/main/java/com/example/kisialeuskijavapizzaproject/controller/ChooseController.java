package com.example.kisialeuskijavapizzaproject.controller;

import com.example.kisialeuskijavapizzaproject.service.impl.ChooseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class ChooseController {

    private final ChooseService service;

    @GetMapping(value = "/get-earnings-table")
    public List<String> getEarnTable() {
        return service.getEarningsCafesTable();
    }

    @GetMapping(value = "/get-cafe-pizza/{id}/{pizzaId}")
    public List<String> getCafePersonId(@PathVariable Integer id,@PathVariable Integer pizzaId){
        return service.selectById(id,pizzaId);
    }

    @GetMapping(value = "/get-earnings-cafe/{Id}")
    public List<String> getEarCafe(@PathVariable Integer Id){
        return service.getEarningsCafe(Id);
    }
}
