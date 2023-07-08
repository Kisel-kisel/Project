package com.example.kisialeuskijavapizzaproject.repositaries;


import com.example.kisialeuskijavapizzaproject.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    @Query(value = "SELECT project.pizza.count\n" +
            "FROM project.pizza\n" +
            "WHERE cafe_id = ? AND  pizza_category_id = ?;", nativeQuery = true )
    Integer pizzaFindCount(Integer cafeId, Integer pizzaId);
}

