package com.example.kisialeuskijavapizzaproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@Entity
@Table(name = "cafes", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "phone")
    private String phone;

    @Column(name = "workingTime")
    private String workingTime;

}
