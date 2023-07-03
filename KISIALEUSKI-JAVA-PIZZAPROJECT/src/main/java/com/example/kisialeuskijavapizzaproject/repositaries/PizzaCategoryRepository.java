package com.example.kisialeuskijavapizzaproject.repositaries;

import com.example.kisialeuskijavapizzaproject.entity.PizzaCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PizzaCategoryRepository extends JpaRepository<PizzaCategory, Integer> {

//    @Query(value = "SELECT *\n" +
//            "FROM project.pizza_category\n" +
//            "JOIN project.category_one ON pizza_category.categories_of_ingredients_id = category_one.categories_of_ingredients_id\n" +
//            "WHERE project.pizza_category.id=?;", nativeQuery = true )
//    Optional<PizzaCategory> selectCatById(Integer id);

}
