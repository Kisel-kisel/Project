package com.example.kisialeuskijavapizzaproject.service;

import com.example.kisialeuskijavapizzaproject.entity.Cafe;
import com.example.kisialeuskijavapizzaproject.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    /**
     * Shows all orders
     *
     * @return all orders
     */
    List<Order> getOrder();

    /**
     * Shows selected order
     *
     * @param id id of a order
     *
     * @return selected order
     */
    Optional<Order> findById(Integer id);
    /**
     * Delete a order by id
     *
     * @param id id of a order
     *
     * @return is deleted order or not
     */
    void  deleateOrder(Integer id);
    /**
     * Add new order
     * @param order new order's parameters
     */
    void addOrder(Order order);

    /**
     * Ordering, withdraws money from the account, sets the order to the position paid and confirmed
     * @param order announced order
     */

    void changeIsPaid(Order order);

    /**
     * Sets the order to the delivered position and subtracts the pizza from their quantity
     * @param order made order
     */
    void changeIsDelivered(Order order);
}
