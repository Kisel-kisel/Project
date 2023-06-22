package com.example.kisialeuskijavapizzaproject.controller;

import com.example.kisialeuskijavapizzaproject.entity.Person;
import com.example.kisialeuskijavapizzaproject.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping(value = "/get-all-person")
    public List<Person> getAllPerson() {
        return service.getPerson();
    }

    @GetMapping(value = "/get-person/{id}")
    public Optional<Person> getAPersona(@PathVariable(name = "id") Integer id) {
        return service.findPersonById(id);
    }

    @DeleteMapping(value = "/delete-person/{id}")
    public void deleteAPerson(@PathVariable Integer id) {
        service.deleatePerson(id);
    }

    @PostMapping(value = "/add-person")
    public Person addNewPerson(@RequestBody Person person) {
        service.addPerson(person);
        return person;
    }

    @PutMapping(value = "/update-person/{id}")
    public void putPerson(@PathVariable(name = "id") Integer id, @RequestBody Person pizzaData) {
        pizzaData.setId(id);
        service.addPerson(pizzaData);
    }
}
