package com.example.kisialeuskijavapizzaproject.service;

import java.util.List;

public interface ChooseService {
  List<String>selectById(Integer id, Integer pizzaId);
  List<String> getEarningsCafe(Integer cafeId );
  List<String> getEarningsCafesTable();
}
