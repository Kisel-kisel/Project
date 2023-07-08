package com.example.kisialeuskijavapizzaproject.controller;

import com.example.kisialeuskijavapizzaproject.entity.Cafe;
import com.example.kisialeuskijavapizzaproject.service.CafeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CafeController {


    private final CafeService service;


    @GetMapping(value = "/get-all-cafes")
    public ResponseEntity<List<Cafe>> getAllCafes() {
        List<Cafe> cafes = service.getCafes();
        return cafes != null ? ResponseEntity.ok(cafes) : ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/get-cafe/{id}")
    public ResponseEntity<?> getACafe(@PathVariable(name = "id") Integer id) {
        Optional<Cafe> cafeOptional=service.findById(id);
        Cafe cafe = cafeOptional.get();
        return cafeOptional != null ? ResponseEntity.ok(cafe) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/delete-cafe/{id}")
    public ResponseEntity<String> deleteACafe(@PathVariable Integer id) {
        boolean deleted = service.deleteCafe(id);
        return deleted ? ResponseEntity.ok("Cafe with ID " + id + " deleted successfully") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cafe with ID " + id + " not found");
    }


    @PostMapping(value = "/add-сafe")
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

