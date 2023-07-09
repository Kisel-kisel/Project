package com.example.kisialeuskijavapizzaproject.service;

import com.example.kisialeuskijavapizzaproject.entity.Person;
import com.example.kisialeuskijavapizzaproject.entity.PizzaCategory;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    /**
     * Shows all persons
     *
     * @return all persons
     */
    List<Person> getPerson();

    /**
     * Shows selected person
     *
     * @param id id of a person
     *
     * @return selected person
     */

    Optional<Person> findPersonById(Integer id);

    /**
     * Delete a person by id
     *
     * @param id id of a person
     *
     * @return is deleted person or not
     */
    void  deleatePerson(Integer id);

    /**
     * Add new person
     *
     * @param person new cafe's parameters
     */
    void addPerson(Person person);
}
