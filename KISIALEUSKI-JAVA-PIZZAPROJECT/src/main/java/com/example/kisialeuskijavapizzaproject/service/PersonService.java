package com.example.kisialeuskijavapizzaproject.service;

import com.example.kisialeuskijavapizzaproject.entity.Person;
import com.example.kisialeuskijavapizzaproject.entity.PizzaCategory;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getPerson();
    Optional<Person> findPersonById(Integer id);
    void  deleatePerson(Integer id);
    void addPerson(Person Person);
}
