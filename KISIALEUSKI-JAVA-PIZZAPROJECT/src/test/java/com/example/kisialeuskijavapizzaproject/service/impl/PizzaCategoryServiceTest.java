package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.entity.PizzaCategory;
import com.example.kisialeuskijavapizzaproject.repositaries.PizzaCategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PizzaCategoryServiceTest {

    @Mock
    private PizzaCategoryRepository pizzaCategoryRepository;

    @InjectMocks
    private PizzaCategoryService pizzaCategoryService;

    @Test
    void testGetPizzaCategories() {
        List<PizzaCategory> expectedPizzaCategories = new ArrayList<>();

        when(pizzaCategoryRepository.findAll()).thenReturn(expectedPizzaCategories);

        List<PizzaCategory> actualPizzaCategories = pizzaCategoryService.getCategoryPizza();

        verify(pizzaCategoryRepository, times(1)).findAll();
        assertEquals(expectedPizzaCategories, actualPizzaCategories);
    }

    @Test
    void testFindById() {
        PizzaCategory expectedPizzaCategory = new PizzaCategory();
        expectedPizzaCategory.setId(100);
        Integer id = expectedPizzaCategory.getId();

        when(pizzaCategoryRepository.findById(id)).thenReturn(Optional.of(expectedPizzaCategory));

        Optional<PizzaCategory> actualPizzaCategory = pizzaCategoryService.findPizzaCategoryById(id);

        assertEquals(Optional.of(expectedPizzaCategory), actualPizzaCategory);
    }

    @Test
    void testAddPizzaCategory() {
        PizzaCategory pizzaCategory = new PizzaCategory();

        pizzaCategoryService.addPizzaCategory(pizzaCategory);

        verify(pizzaCategoryRepository, times(1)).save(pizzaCategory);
    }
}
