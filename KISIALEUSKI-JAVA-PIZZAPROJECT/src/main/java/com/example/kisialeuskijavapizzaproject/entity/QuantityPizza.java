package com.example.kisialeuskijavapizzaproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "quantityPizza", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
public class QuantityPizza {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "pizza_category_id")
    private Integer pizzaCategoryId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "quantity")
    private Float quantity;
}
