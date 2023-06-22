package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.entity.Cafe;
import com.example.kisialeuskijavapizzaproject.repositaries.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CafeService implements com.example.kisialeuskijavapizzaproject.service.CafeService {

    @Autowired
    private CafeRepository cafeRepository;

    @Override
    public List<Cafe> getCafes(){
        List<Cafe> cafes = cafeRepository.findAll();
        return cafes;
    }

    @Override
    public Optional<Cafe> findById(Integer id){
      Optional cafe = cafeRepository.findById(id);
      return cafe;
    }

    @Override
    public void deleateCafe(Integer id){
        cafeRepository.deleteById(id);
    }

    @Override
    public void addCafe(Cafe cafe){
        cafeRepository.save(cafe);
    }


}
