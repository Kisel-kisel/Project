package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.entity.Cafe;
import com.example.kisialeuskijavapizzaproject.repositaries.CafeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CafeServiceTest {

    @Mock
    private CafeRepository cafeRepository;

    @InjectMocks
    private CafeService cafeService;

    @Test
    void testGetCafes(){
        List<Cafe> expectedCafes = new ArrayList<>();

        when(cafeRepository.findAll()).thenReturn(expectedCafes);

        List<Cafe> actualCafes = cafeService.getCafes();

        verify(cafeRepository, times(1)).findAll();
        assertEquals(expectedCafes, actualCafes );
    }

    @Test
    void testFindById(){
        Cafe expectedCafe = new Cafe();
        expectedCafe.setId(100);
        Integer id = expectedCafe.getId();

        when(cafeRepository.findById(id)).thenReturn(Optional.of(expectedCafe));

        Optional actualCafe = cafeService.findById(id);

        assertEquals(Optional.of(expectedCafe),actualCafe);
    }


    @Test
    void testAddCafe(){
        Cafe cafe = new Cafe();

        cafeService.addCafe(cafe);

        verify(cafeRepository, times(1)).save(cafe);
    }
}