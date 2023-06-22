package com.example.kisialeuskijavapizzaproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "person_security", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
public class PersonSecurity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "person_id")
    private Integer personId;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    private Status status;
}
