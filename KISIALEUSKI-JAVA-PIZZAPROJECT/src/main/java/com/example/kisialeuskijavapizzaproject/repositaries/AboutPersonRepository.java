package com.example.kisialeuskijavapizzaproject.repositaries;

import com.example.kisialeuskijavapizzaproject.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AboutPersonRepository extends JpaRepository<Pizza,Integer> {

//    -- 1.Какие пиццы покупает
    @Query(value = "SELECT pizza_category.name\n" +
            "FROM project.pizza_category\n" +
            "JOIN project.\"order\" ON pizza_category.id=\"order\".pizza_category_id\n" +
            "WHERE person_id=?", nativeQuery = true )
    List<String> pizzaPersonLike(Integer id);
//-- 2.В какие кафе человек ходит
    @Query(value = "SELECT cafes.name\n" +
            "FROM project.cafes\n" +
            "         JOIN project.\"order\" ON cafes.id=\"order\".cafe_id\n" +
            "WHERE person_id=?", nativeQuery = true )
    List<String> cafePersonLike(Integer id);
//-- 3.Сколько денег оставил
    @Query(value = "SELECT sum(pizza_category.price) AS payment\n" +
            "FROM project.pizza_category\n" +
            "JOIN project.\"order\" ON pizza_category.id=\"order\".pizza_category_id\n" +
            "WHERE person_id=?", nativeQuery = true )
    Integer personMoney(Integer id);

//    4.Количество заказов сделал
    @Query(value = "SELECT  count(*) as count_of_orders\n" +
            "FROM project.pizza_category\n" +
            "JOIN project.\"order\" ON pizza_category.id=\"order\".pizza_category_id\n" +
            "WHERE person_id=?", nativeQuery = true )
    Integer countOfOrders(Integer id);


}
