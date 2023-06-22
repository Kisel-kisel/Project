package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.entity.Order;
import com.example.kisialeuskijavapizzaproject.entity.PizzaCategory;
import com.example.kisialeuskijavapizzaproject.repositaries.OrderRepository;
import com.example.kisialeuskijavapizzaproject.repositaries.PizzaCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements com.example.kisialeuskijavapizzaproject.service.OrderService {
    @Autowired
    private OrderRepository OrderRepository;
    private PizzaCategoryRepository pizzaCategoryRepository;

    @Override
    public List<Order> getOrder(){
        List<Order> orders = OrderRepository.findAll();
        return orders;
    }

    @Override
    public Optional<Order> findById(Integer id){
        Optional order = OrderRepository.findById(id);
        return order;
    }

    @Override
    public void deleateOrder(Integer id){
        OrderRepository.deleteById(id);
    }

    @Override
    public void addOrder(Order order){
        OrderRepository.save(order);
    }

//    public void change(Integer id){
//        PizzaCategory pizzaCategory = new PizzaCategory();
//        if (id == pizzaCategory.getPrice()){
//
//        }
//    }
}
