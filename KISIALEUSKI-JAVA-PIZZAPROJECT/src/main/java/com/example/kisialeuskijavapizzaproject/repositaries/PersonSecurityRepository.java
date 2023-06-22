package com.example.kisialeuskijavapizzaproject.repositaries;

import com.example.kisialeuskijavapizzaproject.entity.Person;
import com.example.kisialeuskijavapizzaproject.entity.PersonSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonSecurityRepository extends JpaRepository<PersonSecurity, Integer> {
}
