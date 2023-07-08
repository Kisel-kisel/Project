package com.example.kisialeuskijavapizzaproject.repositaries;

import com.example.kisialeuskijavapizzaproject.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChooseRepositary extends JpaRepository<Pizza,Integer> {

    //    Количество определённой категории пиццы в определённом кафе
    @Query(value = "SELECT cafes.name, pizza_category.name, pizza.count\n" +
            "            FROM project.cafes\n" +
            "            JOIN project.pizza ON cafes.id = pizza.cafe_id\n" +
            "            JOIN project.pizza_category ON pizza.pizza_category_id = pizza_category.id\n" +
            "            WHERE cafes.id=? and pizza_category_id=?", nativeQuery = true)
    List<String> selectById(Integer id, Integer pizzaId);

    //Количество денег заработанное кафе
    @Query(value = "SELECT project.cafes.name, sum(price)\n" +
            "FROM project.pizza_category\n" +
            "JOIN project.\"order\" on pizza_category.id = \"order\".pizza_category_id\n" +
            "JOIN project.cafes  on cafes.id = \"order\".cafe_id\n" +
            "WHERE cafe_id=?\n" +
            "GROUP BY project.cafes.name", nativeQuery = true)
    List<String> earningsCafe(Integer cafeId);

    //Количество денег заработанное всеми кафе
    @Query(value = "SELECT project.cafes.name, sum(price) AS earnings\n" +
            "FROM project.pizza_category\n" +
            "JOIN project.\"order\" on pizza_category.id = \"order\".pizza_category_id\n" +
            "JOIN project.cafes  on cafes.id = \"order\".cafe_id\n" +
            "GROUP BY project.cafes.name\n" +
            "order by earnings DESC", nativeQuery = true)
    List<String> earningsCafesTable();
}