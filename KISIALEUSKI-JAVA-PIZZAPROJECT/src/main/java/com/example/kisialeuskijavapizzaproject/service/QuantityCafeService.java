package com.example.kisialeuskijavapizzaproject.service;

import com.example.kisialeuskijavapizzaproject.entity.QuantityCafe;

import java.util.List;

public interface QuantityCafeService {

    /**
     * Shows the quantity of all products in a certain cafe
     *
     * @param cafeId a certain cafe
     *
     * @return quantity of all products in a certain cafe
     */
    List<QuantityCafe> findAllQuantityCafesByCafeId(Integer cafeId);

    /**
     * Saves the changed amount of pizza
     * @param quantityCafe a cafe with changed amount of pizza
     */
    void saveQuantityCafe(QuantityCafe quantityCafe);
}
