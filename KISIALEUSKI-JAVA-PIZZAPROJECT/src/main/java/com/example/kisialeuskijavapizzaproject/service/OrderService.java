package com.example.kisialeuskijavapizzaproject.service;

import com.example.kisialeuskijavapizzaproject.entity.Cafe;
import com.example.kisialeuskijavapizzaproject.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getOrder();
    Optional<Order> findById(Integer id);
    void  deleateOrder(Integer id);
    void addOrder(Order order);
    void changeIsPaid(Order order);
    void changeIsDelivered(Order order);
}
