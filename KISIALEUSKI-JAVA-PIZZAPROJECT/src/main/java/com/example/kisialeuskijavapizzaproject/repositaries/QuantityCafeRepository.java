package com.example.kisialeuskijavapizzaproject.repositaries;

import com.example.kisialeuskijavapizzaproject.entity.QuantityCafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantityCafeRepository extends JpaRepository<QuantityCafe, Integer> {

    /**
     * Shows the quantity of all products in a certain cafe
     *
     * @param cafeId a certain cafe
     *
     * @return quantity of all products in a certain cafe
     */
    @Query(value = "SELECT  id, cafe_id, product_id, quantity, unit\n" +
            "FROM  project.quantity_cafe\n" +
            "WHERE cafe_id = ?\n" +
            "ORDER BY product_id;", nativeQuery = true )
    List<QuantityCafe> findAllCafesByCafeId(Integer cafeId);
}
