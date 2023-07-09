package com.example.kisialeuskijavapizzaproject.repositaries;

import com.example.kisialeuskijavapizzaproject.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AboutPersonRepository extends JpaRepository<Pizza,Integer> {

    /**
     *Shows which pizzas a certain person bought
     *
     * @param id id of the certain person
     *
     * @return pizzas a person bought
     */

    @Query(value = "SELECT pizza_category.name\n" +
            "FROM project.pizza_category\n" +
            "JOIN project.\"order\" ON pizza_category.id=\"order\".pizza_category_id\n" +
            "WHERE person_id=?", nativeQuery = true )
    List<String> pizzaPersonLike(Integer id);

    /**
     *Shows which cafes a person went to
     *
     * @param id id of the certain person
     *
     * @return cafes a person went to
     */

    @Query(value = "SELECT cafes.name\n" +
            "FROM project.cafes\n" +
            "         JOIN project.\"order\" ON cafes.id=\"order\".cafe_id\n" +
            "WHERE person_id=?", nativeQuery = true )
    List<String> cafePersonLike(Integer id);

    /**
     *Shows how much money the cafe earned a person
     *
     * @param id id of the certain person
     *
     * @return how much money the cafe earned a person
     */

    @Query(value = "SELECT sum(pizza_category.price) AS payment\n" +
            "FROM project.pizza_category\n" +
            "JOIN project.\"order\" ON pizza_category.id=\"order\".pizza_category_id\n" +
            "WHERE person_id=?", nativeQuery = true )
    Integer personMoney(Integer id);

    /**
     *Shows the number of orders made a person
     *
     * @param id id of the certain person
     *
     * @return the number of orders made a person
     */

    @Query(value = "SELECT  count(*) as count_of_orders\n" +
            "FROM project.pizza_category\n" +
            "JOIN project.\"order\" ON pizza_category.id=\"order\".pizza_category_id\n" +
            "WHERE person_id=?", nativeQuery = true )
    Integer countOfOrders(Integer id);


}
