package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.entity.*;
import com.example.kisialeuskijavapizzaproject.repositaries.OrderRepository;
import com.example.kisialeuskijavapizzaproject.repositaries.PersonRepository;
import com.example.kisialeuskijavapizzaproject.repositaries.PizzaCategoryRepository;
import com.example.kisialeuskijavapizzaproject.repositaries.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private PersonRepository personRepository;

    @Mock
    private PizzaRepository pizzaRepository;

    @Mock
    private PizzaCategoryRepository pizzaCategoryRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void changeIsPaidTest_WhenPersonHasEnoughMoney(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Order order = new Order(1, timestamp,1,1,1, ConfirmStatus.PROCESSED,false,false);
        PizzaCategory pizzaCategory = new PizzaCategory(1,"Italiano", Size.SMALL,10);
        Person person = new Person(1,timestamp,"","","","",20);

        when(orderRepository.findById(order.getId())).thenReturn(Optional.of(order));
        when(personRepository.findById(order.getPersonId())).thenReturn(Optional.of(person));
        when(pizzaCategoryRepository.findById(order.getPizzaCategoryId())).thenReturn(Optional.of(pizzaCategory));


        orderService.changeIsPaid(order);

        assertTrue(order.isPaid());
        assertEquals(ConfirmStatus.CONFIRMED, order.getConfirmStatus());
        assertEquals(10, Optional.ofNullable(person.getMoney()).orElse(0));
        verify(personRepository, times(1)).save(person);
        verify(orderRepository, times(1)).save(order);

    }

    @Test
    void testChangeIsPaid_WhenPersonDoesNotHaveEnoughMoney() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Order order = new Order(1, timestamp,1,1,1, ConfirmStatus.PROCESSED,false,false);
        PizzaCategory pizzaCategory = new PizzaCategory(1,"Italiano", Size.SMALL,10);
        Person person = new Person(1,timestamp,"","","","",9);

        when(orderRepository.findById(order.getId())).thenReturn(Optional.of(order));
        when(personRepository.findById(order.getPersonId())).thenReturn(Optional.of(person));
        when(pizzaCategoryRepository.findById(order.getPizzaCategoryId())).thenReturn(Optional.of(pizzaCategory));


        orderService.changeIsPaid(order);


        assertFalse(order.isPaid());
        assertEquals(ConfirmStatus.PROCESSED, order.getConfirmStatus());
        assertEquals(9, person.getMoney());
        verify(personRepository, times(0)).save(person);
        verify(orderRepository, times(0)).save(order);
    }

    @Test
    void ChangeIsDelivered_OrderIsDelivered_PizzaCountDecreased(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Pizza pizza = new Pizza(1,1,1,20);
        Order order = new Order(1, timestamp,1,1,1, ConfirmStatus.CONFIRMED,true,true);
    


        when(orderRepository.save(order)).thenReturn(order);
//        when(orderRepository.findById(order.getPizzaCategoryId())).thenReturn(Optional.of(order));
        when(pizzaRepository.findById(order.getPizzaCategoryId())).thenReturn(Optional.of(pizza));
        when(pizzaRepository.save(pizza)).thenReturn(pizza);

        orderService.changeIsDelivered(order);

        assertTrue(order.getIsDelivered());
        assertEquals(19,pizza.getCount());
        verify(orderRepository,times(1)).save(order);
        verify(pizzaRepository,times(1)).save(pizza);

    }

    @Test
    void testGetOrder(){
        List<Order> expectedOrders = new ArrayList<>();

        when(orderRepository.findAll()).thenReturn(expectedOrders);

        List<Order> actualOrders = orderService.getOrder();

        verify(orderRepository, times(1)).findAll();
        assertEquals(expectedOrders, actualOrders);
    }

    @Test
    void testFindById(){
        Order expectedOrder = new Order();
        expectedOrder.setId(1);
        Integer id = expectedOrder.getId();

        when(orderRepository.findById(id)).thenReturn(Optional.of(expectedOrder));

        Optional actualOrders = orderService.findById(id);

        assertEquals(Optional.of(expectedOrder), actualOrders);
    }

    @Test
    void testDeleateOrder(){
        Integer orderId = 1;

        orderService.deleateOrder(orderId);

        verify(orderRepository, times(1)).deleteById(orderId);
    }

    @Test
    void testAddOrder() {
        Order order = new Order();

        orderService.addOrder(order);

        verify(orderRepository, times(1)).save(order);
    }
}