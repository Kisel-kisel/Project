package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.entity.Person;
import com.example.kisialeuskijavapizzaproject.repositaries.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements com.example.kisialeuskijavapizzaproject.service.PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getPerson(){
        List<Person> Person = personRepository.findAll();
        return Person;
    }

    @Override
    public Optional<Person> findPersonById(Integer id){
        Optional Person = personRepository.findById(id);
        return Person;
    }

    @Override
    public void deleatePerson(Integer id){
        personRepository.deleteById(id);
    }

    @Override
    public void addPerson(Person person){
        personRepository.save(person);
    }


}
