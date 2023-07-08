package com.example.kisialeuskijavapizzaproject.repositaries;
import com.example.kisialeuskijavapizzaproject.entity.QuantityPizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuantityPizzaRepository extends JpaRepository<QuantityPizza, Integer> {
    @Query(value = "SELECT  id, pizza_category_id, product_id, quantity\n" +
            "FROM project.quantity_pizza\n" +
            "WHERE pizza_category_id = ?\n" +
            "ORDER BY product_id", nativeQuery = true )
    List<QuantityPizza> findPizzaById(Integer pizzaId);
}
