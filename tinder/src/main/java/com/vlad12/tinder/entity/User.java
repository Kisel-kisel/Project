package com.vlad12.tinder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private Sex sex;
    @Column
    private int point;

}
