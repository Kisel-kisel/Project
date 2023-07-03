package com.example.kisialeuskijavapizzaproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;;

@Data
@Entity
@Table(name = "pizza_category", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
public class PizzaCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    @Enumerated(EnumType.STRING)
    private Size size;

    @Column(name = "price")
    private Integer price;


}
