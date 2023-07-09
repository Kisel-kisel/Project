package com.example.kisialeuskijavapizzaproject.repositaries;


import com.example.kisialeuskijavapizzaproject.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

    /**
     *Shows the quantity of a certain category of pizza in a certain cafe
     *
     * @param cafeId  certain cafe
     * @param pizzaId certain category of pizza
     *
     * @return quantity of selected category of pizza in a selected cafe
     */
    @Query(value = "SELECT project.pizza.count\n" +
            "FROM project.pizza\n" +
            "WHERE cafe_id = ? AND  pizza_category_id = ?;", nativeQuery = true )
    Integer pizzaFindCount(Integer cafeId, Integer pizzaId);
}

