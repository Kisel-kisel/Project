package com.example.kisialeuskijavapizzaproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pizza", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "pizza_category_id")
    private Integer pizzaCategoryId;

    @Column(name = "cafe_id")
    private Integer cafeId;

    @Column(name = "count")
    private Integer count;

}
