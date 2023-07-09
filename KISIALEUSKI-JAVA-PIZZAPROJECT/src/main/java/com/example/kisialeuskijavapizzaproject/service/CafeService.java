package com.example.kisialeuskijavapizzaproject.service;

import com.example.kisialeuskijavapizzaproject.entity.Cafe;

import java.util.List;
import java.util.Optional;

public interface CafeService {

   /**
    * Shows all cafes
    *
    * @return all cafes
    */

   List<Cafe> getCafes();

   /**
    * Shows selected cafe
    *
    * @param id id of a cafe
    *
    * @return selected cafe
    */
   Optional<Cafe> findById(Integer id);

   /**
    * Delete a cafe by id
    *
    * @param id id of a cafe
    *
    * @return is deleted cafe or not
    */
   boolean deleteCafe(Integer id);

   /**
    * Add new cafe
    *
    * @param cafe new cafe's parameters
    */
   void addCafe(Cafe cafe);


}
