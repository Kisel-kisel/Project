package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.repositaries.ChooseRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChooseService implements com.example.kisialeuskijavapizzaproject.service.ChooseService {
    @Autowired
    private ChooseRepositary chooseRepositary;

    @Override
    public List<String>selectById(Integer id,Integer pizzaId) {
        return chooseRepositary.selectById(id, pizzaId);
    }
    @Override
    public List<String> getEarningsCafe(Integer cafeId ){
        return chooseRepositary.earningsCafe(cafeId);
        }

        @Override
    public List<String> getEarningsCafesTable(){
        return chooseRepositary.earningsCafesTable();
    }

    }

