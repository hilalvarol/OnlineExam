package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @Column(name = "email", nullable = false, length = 30)
    private String id;

    @Column(name = "id", nullable = false, length = 10)
    private String id1;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "role", nullable = false, length = 10)
    private String role;


}