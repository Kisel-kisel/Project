package com.example.kisialeuskijavapizzaproject.service.impl;
import com.example.kisialeuskijavapizzaproject.entity.PizzaCategory;
import com.example.kisialeuskijavapizzaproject.repositaries.PizzaCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaCategoryService implements com.example.kisialeuskijavapizzaproject.service.PizzaCategoryService {
    @Autowired
    private PizzaCategoryRepository pizzaCategoryRepository;

    @Override
    public List<PizzaCategory> getCategoryPizza(){
        List<PizzaCategory> pizzasCategory = pizzaCategoryRepository.findAll();
        return pizzasCategory;
    }

    @Override
    public Optional<PizzaCategory> findPizzaCategoryById(Integer id){
        Optional pizzaCategory = pizzaCategoryRepository.findById(id);
        return pizzaCategory;
    }

    @Override
    public void deleatePizzaCategory(Integer id){
        pizzaCategoryRepository.deleteById(id);
    }

    @Override
    public void addPizzaCategory(PizzaCategory pizzaCategory){
        pizzaCategoryRepository.save(pizzaCategory);
    }


        }



