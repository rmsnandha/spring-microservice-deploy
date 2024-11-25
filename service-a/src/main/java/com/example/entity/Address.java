package com.example.service1.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Library library;

    @OneToOne(mappedBy = "address")
    private Employee employee;
}