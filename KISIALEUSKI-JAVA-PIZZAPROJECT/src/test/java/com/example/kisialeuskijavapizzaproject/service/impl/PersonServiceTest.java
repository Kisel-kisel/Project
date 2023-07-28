package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.entity.Person;
import com.example.kisialeuskijavapizzaproject.repositaries.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGetPersons() {
        List<Person> expectedPersons = new ArrayList<>();

        when(personRepository.findAll()).thenReturn(expectedPersons);

        List<Person> actualPersons = personService.getPerson();

        verify(personRepository, times(1)).findAll();
        assertEquals(expectedPersons, actualPersons);
    }

    @Test
    void testFindById() {
        Person expectedPerson = new Person();
        expectedPerson.setId(100);
        Integer id = expectedPerson.getId();

        when(personRepository.findById(id)).thenReturn(Optional.of(expectedPerson));

        Optional<Person> actualPerson = personService.findPersonById(id);

        assertEquals(Optional.of(expectedPerson), actualPerson);
    }

    @Test
    void testAddPerson() {
        Person person = new Person();

        personService.addPerson(person);

        verify(personRepository, times(1)).save(person);
    }
}
