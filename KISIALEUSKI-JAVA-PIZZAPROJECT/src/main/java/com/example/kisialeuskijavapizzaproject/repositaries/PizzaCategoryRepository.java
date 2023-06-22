package com.example.kisialeuskijavapizzaproject.repositaries;

import com.example.kisialeuskijavapizzaproject.entity.PizzaCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PizzaCategoryRepository extends JpaRepository<PizzaCategory, Integer> {

}
