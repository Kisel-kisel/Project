package com.example.kisialeuskijavapizzaproject.service;
import java.util.List;


public interface AboutPersons  {

    /**
     * Shows selected pizza
     *
     * @param id id of a pizza
     *
     * @return selected pizza
     */
    List<String> getPizzaPersonLike(Integer id);

    /**
     * Shows selected cafe
     *
     * @param id id of a cafe
     *
     * @return selected cafe
     */
    List<String> getCafePersonLike(Integer id);

    /**
     *Shows the amount of money in the account
     *
     * @param id account of a person
     *
     * @return the amount of money in the account
     */
    Integer getPersonMoney(Integer id);

    /**
     *Shows the number of orders made a person
     *
     * @param id id of the certain person
     *
     * @return the number of orders made a person
     */

    Integer getCountOfOrders(Integer id);
}
