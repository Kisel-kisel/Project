package com.example.kisialeuskijavapizzaproject.service;
import java.util.List;


public interface AboutPersons  {
    List<String> getPizzaPersonLike(Integer id);
    List<String> getCafePersonLike(Integer id);
    Integer getPersonMoney(Integer id);
    Integer getCountOfOrders(Integer id);
}
