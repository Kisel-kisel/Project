package com.example.kisialeuskijavapizzaproject.controller;

import com.example.kisialeuskijavapizzaproject.entity.Cafe;
import com.example.kisialeuskijavapizzaproject.entity.Order;
import com.example.kisialeuskijavapizzaproject.service.CafeService;
import com.example.kisialeuskijavapizzaproject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @GetMapping(value = "/get-all-orders")
    public List<Order> getAllCafes() {
        return service.getOrder();
    }

    @GetMapping(value = "/get-order/{id}")
    public Optional<Order> getAOrder(@PathVariable(name = "id") Integer id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/delete-order/{id}")
    public void deleteAOrder(@PathVariable Integer id) {
        service.deleateOrder(id);
    }

    @PostMapping(value = "/addOrder")
    public Order addNewOrder(@RequestBody Order order) {
        service.addOrder(order);
        return order;
    }

    @PutMapping(value = "/update-Order/{id}")
    public void putCafe(@PathVariable(name = "id") Integer id, @RequestBody Order order){
        order.setId(id);
        service.addOrder(order);
    }
}
