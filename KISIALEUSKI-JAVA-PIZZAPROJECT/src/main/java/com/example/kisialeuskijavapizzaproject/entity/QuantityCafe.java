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
@Table(name = "quantityCafe", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
public class QuantityCafe {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "cafe_id")
    private Integer cafeId;

    @Column(name = "product_ID")
    private Integer productId;

    @Column(name = "quantity")
    private Float quantity;



}
