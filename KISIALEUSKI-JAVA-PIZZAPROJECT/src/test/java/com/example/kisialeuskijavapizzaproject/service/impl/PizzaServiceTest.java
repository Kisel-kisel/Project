package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.entity.Pizza;
import com.example.kisialeuskijavapizzaproject.entity.QuantityCafe;
import com.example.kisialeuskijavapizzaproject.entity.QuantityPizza;
import com.example.kisialeuskijavapizzaproject.repositaries.PizzaRepository;
import com.example.kisialeuskijavapizzaproject.service.QuantityCafeService;
import com.example.kisialeuskijavapizzaproject.service.QuantityPizzaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class PizzaServiceTest {

    @Mock
    private PizzaRepository pizzaRepository;

    @Mock
    private QuantityCafeService quantityCafeService;

    @Mock
    private QuantityPizzaService quantityPizzaService;

    @InjectMocks
    private PizzaService pizzaService;

    @Test
    public void testAddPizza() {
        Integer cafeId = 1;
        Integer pizzaId = 1;
        Integer oldCount = 5;
        Integer newCount = 10;

        Pizza pizza = new Pizza();
        pizza.setCafeId(cafeId);
        pizza.setPizzaCategoryId(pizzaId);
        pizza.setCount(newCount);

        when(pizzaRepository.pizzaFindCount(cafeId, pizzaId)).thenReturn(oldCount);

        when(pizzaRepository.save(pizza)).thenReturn(pizza);

        List<QuantityCafe> list = new ArrayList<>();
        when(quantityCafeService.findAllQuantityCafesByCafeId(cafeId)).thenReturn(list);

        List<QuantityPizza> listPizza = new ArrayList<>();
        when(quantityPizzaService.findQuantityPizzaById(pizzaId)).thenReturn(listPizza);

        pizzaService.addPizza(pizza);

        verify(pizzaRepository, times(1)).pizzaFindCount(cafeId, pizzaId);

        verify(pizzaRepository, times(1)).save(pizza);

        verify(quantityCafeService, times(1)).findAllQuantityCafesByCafeId(cafeId);

        verify(quantityPizzaService, times(1)).findQuantityPizzaById(pizzaId);
    }
}
