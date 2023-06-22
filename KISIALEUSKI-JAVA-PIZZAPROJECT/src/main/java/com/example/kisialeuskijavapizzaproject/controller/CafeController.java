package com.example.kisialeuskijavapizzaproject.controller;

import com.example.kisialeuskijavapizzaproject.entity.Cafe;
import com.example.kisialeuskijavapizzaproject.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CafeController {


    private final CafeService service;

    @GetMapping(value = "/get-all-cafes")
    public List<Cafe> getAllCafes() {
        return service.getCafes();
    }

    @GetMapping(value = "/get-cafe/{id}")
    public Optional<Cafe> getACafe(@PathVariable(name = "id") Integer id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/delete-cafe/{id}")
    public void deleteACafe(@PathVariable Integer id) {
        service.deleateCafe(id);
    }

    @PostMapping(value = "/addCafe")
    public Cafe addNewCafe(@RequestBody Cafe cafe) {
        service.addCafe(cafe);
        return cafe;
    }

    @PutMapping(value = "/update-cafe/{id}")
    public void putCafe(@PathVariable(name = "id") Integer id, @RequestBody Cafe cafeData){
        cafeData.setId(id);
    service.addCafe(cafeData);
}
}

