package com.example.kisialeuskijavapizzaproject.repositaries;

import com.example.kisialeuskijavapizzaproject.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
