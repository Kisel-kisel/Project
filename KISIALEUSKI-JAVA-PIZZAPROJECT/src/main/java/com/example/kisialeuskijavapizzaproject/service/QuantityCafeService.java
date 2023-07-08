package com.example.kisialeuskijavapizzaproject.service;

import com.example.kisialeuskijavapizzaproject.entity.QuantityCafe;

import java.util.List;

public interface QuantityCafeService {
    List<QuantityCafe> findAllQuantityCafesByCafeId(Integer cafeId);
    void saveQuantityCafe(QuantityCafe quantityCafe);
}
