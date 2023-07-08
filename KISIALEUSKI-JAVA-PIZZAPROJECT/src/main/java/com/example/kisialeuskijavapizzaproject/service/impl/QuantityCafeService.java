package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.entity.QuantityCafe;
import com.example.kisialeuskijavapizzaproject.repositaries.QuantityCafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityCafeService implements com.example.kisialeuskijavapizzaproject.service.QuantityCafeService {

    @Autowired
    private QuantityCafeRepository quantityCafeRepository;

    @Override
    public List<QuantityCafe> findAllQuantityCafesByCafeId(Integer cafeId){
        return quantityCafeRepository.findAllCafesByCafeId(cafeId);
    }
    @Override
    public void saveQuantityCafe(QuantityCafe quantityCafe){
        quantityCafeRepository.save(quantityCafe);
    }
}
