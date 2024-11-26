package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}