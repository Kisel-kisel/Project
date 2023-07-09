package com.example.kisialeuskijavapizzaproject.service;

import java.util.List;

public interface ChooseService {
  /**
   *Shows the quantity of a certain category of pizza in a certain cafe
   *
   * @param id  certain cafe
   * @param pizzaId certain category of pizza
   *
   * @return quantity of selected category of pizza in a selected cafe
   */
  List<String>selectById(Integer id, Integer pizzaId);

  /**
   *shows the amount of money earned by the certain cafe
   *
   * @param cafeId certain cafe
   *
   * @return amount of money earned by the cafe
   */
  List<String> getEarningsCafe(Integer cafeId );

  /**
   *Shows the amount of money earned by all cafes
   *
   * @return amount of money earned by all cafes
   */
  List<String> getEarningsCafesTable();
}
