package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.entity.*;
import com.example.kisialeuskijavapizzaproject.repositaries.OrderRepository;
import com.example.kisialeuskijavapizzaproject.repositaries.PersonRepository;
import com.example.kisialeuskijavapizzaproject.repositaries.PizzaCategoryRepository;
import com.example.kisialeuskijavapizzaproject.repositaries.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class OrderService implements com.example.kisialeuskijavapizzaproject.service.OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PizzaCategoryRepository pizzaCategoryRepository;
    @Autowired
    private PizzaRepository pizzaRepository;


    @Override
    public List<Order> getOrder() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    @Override
    public Optional<Order> findById(Integer id) {
        Optional order = orderRepository.findById(id);
        return order;
    }

    @Override
    public void deleateOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void changeIsPaid(Order order) {
        Optional<Order> optionalOrder = orderRepository.findById(order.getId());
        Optional<Person> optionalPerson = personRepository.findById(order.getPersonId());
        Optional<PizzaCategory> optionalPizzaCategory = pizzaCategoryRepository.findById(order.getPizzaCategoryId());

        Person person = optionalPerson.orElse(new Person());
        PizzaCategory pizzaCategory = optionalPizzaCategory.orElse(new PizzaCategory());
        Order upOrder = optionalOrder.orElse(new Order());

        if (person.getMoney() >= pizzaCategory.getPrice()) {
            person.setMoney(person.getMoney() - pizzaCategory.getPrice());
            upOrder.setPaid(true);
            personRepository.save(person);
            orderRepository.save(upOrder);
        }
        if (order.isPaid()==true){
            order.setConfirmStatus(ConfirmStatus.confirmed);
        }
    }

    @Override
    public void changeIsDelivered(Order order){
        order.setIsDelivered(true);
        orderRepository.save(order);

        Optional<Pizza> optionalPizza = pizzaRepository.findById(order.getPizzaCategoryId());
        Pizza pizza = optionalPizza.orElse(new Pizza());

        if (order.getIsDelivered()==true){
            pizza.setCount(pizza.getCount()-1);
            pizzaRepository.save(pizza);
        }
    }







}
