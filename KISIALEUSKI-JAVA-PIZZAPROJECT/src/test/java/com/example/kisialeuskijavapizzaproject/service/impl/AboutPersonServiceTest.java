package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.entity.Person;
import com.example.kisialeuskijavapizzaproject.repositaries.AboutPersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AboutPersonServiceTest {
    @Mock
    private AboutPersonRepository aboutPersonRepository;

    @InjectMocks
    private AboutPersonService aboutPersonService;

    @Test
    void testGetPizzaPersonLike(){
        List<Person> expectedPerson = new ArrayList<>();
        Integer id = 1;

        when(aboutPersonRepository.pizzaPersonLike(id)).thenReturn(new ArrayList<>());

        List<String> actualPerson = aboutPersonService.getPizzaPersonLike(id);

        assertEquals(expectedPerson,actualPerson);

    }

    @Test
    void testGetCafePersonLike(){
        List<Person> expectedPerson = new ArrayList<>();
        Integer id = 1;

        when(aboutPersonRepository.cafePersonLike(id)).thenReturn(new ArrayList<>());

        List<String> actualPerson = aboutPersonService.getCafePersonLike(id);

        assertEquals(expectedPerson,actualPerson);
    }

    @Test
    void testGetPersonMoney(){
        Integer assertSum = 30;
        Integer id = 1;

        when(aboutPersonRepository.personMoney(id)).thenReturn(assertSum);

        Integer actualSum = aboutPersonService.getPersonMoney(id);

        assertEquals(assertSum,actualSum);
    }

    @Test
    void testGetCountOfOrders(){
        Integer assertCount = 14;
        Integer id = 1;

        when(aboutPersonRepository.countOfOrders(id)).thenReturn(assertCount);

        Integer actualCount = aboutPersonService.getCountOfOrders(id);

        assertEquals(assertCount,actualCount);
    }

}