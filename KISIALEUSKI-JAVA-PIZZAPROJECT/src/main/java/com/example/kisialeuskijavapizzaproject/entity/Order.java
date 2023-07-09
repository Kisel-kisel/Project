package com.example.kisialeuskijavapizzaproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "order", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "cafe_id")
    private Integer cafeId;

    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "pizza_category_id")
    private Integer pizzaCategoryId;

    @Column(name = "confirm_status", columnDefinition = "0")
    private ConfirmStatus confirmStatus;

    @Column(name = "is_Delivered", columnDefinition = "boolean default false")
    private Boolean isDelivered;

    @Column(name = "is_paid",columnDefinition = "boolean default false")
    private boolean isPaid;

}
