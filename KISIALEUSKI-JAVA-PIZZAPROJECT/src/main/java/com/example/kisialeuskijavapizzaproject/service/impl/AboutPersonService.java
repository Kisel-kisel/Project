package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.repositaries.AboutPersonRepository;
import com.example.kisialeuskijavapizzaproject.service.AboutPersons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AboutPersonService implements AboutPersons {

    @Autowired
    private AboutPersonRepository aboutPersonRepository;

    @Override
    public List<String> getPizzaPersonLike(Integer id){
        List<String> pizzas=aboutPersonRepository.pizzaPersonLike(id);
        return pizzas;
    }

    @Override
    public List<String> getCafePersonLike(Integer id){
        List<String> cafes=aboutPersonRepository.cafePersonLike(id);
        return cafes;
    }
    @Override
    public Integer getPersonMoney(Integer id){
        Integer  sum = aboutPersonRepository.personMoney(id);
        return sum;
    }

    @Override
    public Integer getCountOfOrders(Integer id){
        Integer  count = aboutPersonRepository.countOfOrders(id);
        return count;
    }


}



