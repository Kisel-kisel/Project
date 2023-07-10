package com.example.kisialeuskijavapizzaproject.service.impl;

import com.example.kisialeuskijavapizzaproject.entity.*;
import com.example.kisialeuskijavapizzaproject.repositaries.*;
import com.example.kisialeuskijavapizzaproject.service.QuantityCafeService;
import com.example.kisialeuskijavapizzaproject.service.QuantityPizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PizzaService implements com.example.kisialeuskijavapizzaproject.service.PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private QuantityCafeService quantityCafeService;

    @Autowired
    private QuantityPizzaService quantityPizzaService;


    @Transactional
    @Override
    public void addPizza(Pizza pizzaData) {
        Integer cafeId = pizzaData.getCafeId();
        Integer pizzaId = pizzaData.getPizzaCategoryId();
        Integer oldCount = pizzaRepository.pizzaFindCount(cafeId, pizzaId);
        Integer newCount = pizzaData.getCount();
        pizzaRepository.save(pizzaData);

        List<QuantityCafe> list = quantityCafeService.findAllQuantityCafesByCafeId(cafeId);
        List<QuantityPizza> listPizza = quantityPizzaService.findQuantityPizzaById(pizzaId);

        Integer differ = 1;
        if (newCount > oldCount) {
            differ = newCount - oldCount;
        }

        int index2 = 0;
        QuantityCafe cafe = null;

        for (int i = 0; i < listPizza.size(); i++) {
            QuantityPizza quantityPizza = listPizza.get(i);
            int number = quantityPizza.getProductId();

            // Поиск объекта quantityCafe с соответствующим номером продукта
            boolean found = false;
            for (int j = index2; j < list.size(); j++) {
                cafe = list.get(j);
                if (cafe.getProductId() == number) {
                    index2 = j + 1;
                    found = true;
                    break;
                }
            }

            if (found) {
                Float pizzaQuantity = quantityPizza.getQuantity();
                Float result = differ * pizzaQuantity;
                cafe.setQuantity(cafe.getQuantity() - result);
                quantityCafeService.saveQuantityCafe(cafe);
            }
        }


//        for (int i = 0; i < listPizza.size(); i++) {
//            quantityPizza = listPizza.get(i);
////            System.out.println(quantityPizza);
//            quantityCafe = list.get(i);
////            System.out.println(quantityCafe);
//            int number = quantityPizza.getProductId();
////            System.out.println(number);
//
//            while (index2 < list.size() && quantityCafe.getProductId() != number) {
//                index2++;
//                System.out.println(number);
//                System.out.println(index2);
//
//            }
//
//            if (index2 < list.size() && quantityCafe.getProductId() == number) {
//                Float pizzaQuantity = quantityPizza.getQuantity();
////                System.out.println(quantityPizza.getQuantity());
////                System.out.println(quantityCafe.getQuantity());
//                Float resualt = differ * pizzaQuantity;
//                quantityCafe.setQuantity(quantityCafe.getQuantity() - resualt);
//                quantityCafeService.saveQuantityCafe(quantityCafe);
//
//            index2++;
//            }
//
//        }

//        for (int i = 0; i < list.size(); i++) {
//            quantityCafe = list.get(i);
//            System.out.println(quantityCafe);
//            quantityPizza = listPizza.get(i);
//            System.out.println(quantityPizza);
//            if(quantityCafe.getProductId()==quantityPizza.getProductId()){
//
//                System.out.println(quantityCafe.getProductId());
//                System.out.println(quantityPizza.getProductId());
//
//                Float pizzaQuantity = quantityPizza.getQuantity();
//                Float resualt = differ * pizzaQuantity;
//                quantityCafe.setQuantity(quantityCafe.getQuantity() - resualt);
//                quantityCafeService.saveQuantityCafe(quantityCafe);
//            }

        }


//        for (int i = 0; i < list.size(); i++) {
//            quantityCafe = list.get(i);
//            System.out.println(quantityCafe);
//            quantityPizza = listPizza.get(i);
//            System.out.println(quantityPizza);
//            if(quantityCafe.getProductId()==quantityPizza.getProductId()){
//
//                System.out.println(quantityCafe.getProductId());
//                System.out.println(quantityPizza.getProductId());
//
//                Float pizzaQuantity = quantityPizza.getQuantity();
//                Float resualt = differ * pizzaQuantity;
//                quantityCafe.setQuantity(quantityCafe.getQuantity() - resualt);
//                quantityCafeService.saveQuantityCafe(quantityCafe);
//            }




//        for (int i = 0; i < list.size() ; i++) {
//            quantityCafe1=list()
//        }

    }
//}
//
//    @Override
//    public void addPizza(Pizza pizzaData) {
//        Integer cafeId = pizzaData.getCafeId();
//        Integer pizzaId = pizzaData.getPizzaCategoryId();
//        Integer oldCount = pizzaRepository.pizzaFindCount(cafeId, pizzaId);
//        Integer newCount = pizzaData.getCount();
//        pizzaRepository.save(pizzaData);
//
//        List<QuantityCafe> list = quantityCafeService.findAllQuantityCafesByCafeId(cafeId);
//        List<QuantityPizza> listPizza = quantityPizzaService.findQuantityPizzaById(pizzaId);
//        Integer differ = 1;
//        if (newCount > oldCount) {
//            differ = newCount - oldCount;
//        }
//
//        for (int i = 0; i < listPizza.size(); i++) {
//            QuantityCafe quantityCafe = list.get(i);
//
//            QuantityPizza quantityPizza = listPizza.get(i);
//            Float pizzaQuantity = quantityPizza.getQuantity();
//            Float resualt = differ * pizzaQuantity;
//            quantityCafe.setQuantity(quantityCafe.getQuantity() - resualt);
//            quantityCafeService.saveQuantityCafe(quantityCafe);
//        }
//
//    }