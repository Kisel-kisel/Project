package com.example.kisialeuskijavapizzaproject.service;

import com.example.kisialeuskijavapizzaproject.entity.Cafe;

import java.util.List;
import java.util.Optional;

public interface CafeService {
   List<Cafe> getCafes();
   Optional<Cafe> findById(Integer id);
   void  deleateCafe(Integer id);
   void addCafe(Cafe cafe);


}
