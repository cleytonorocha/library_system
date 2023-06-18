package com.github.cleyto_orocha.library_system.entities;

import java.time.Instant;

import org.hibernate.validator.constraints.ISBN;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@AllArgsConstructor @ToString 
public class Book extends Product {

    @Id
    @Column(name = "idBook")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    @NotNull(message = "The author name's required")
    @NotEmpty(message = "The author name connot be empty")
    private String author;

    @Column(length = 100)
    @NotNull(message = "The publisher name's required")
    @NotEmpty(message = "The publisher name connot be empty")
    private String publisher;

    @Column(length = 100)
    @NotNull(message = "The data of book's required")
    @NotEmpty(message = "The data of book connot be empty")
    private Instant data;

    @ISBN
    @NotNull(message = "The ISBN's required")
    @NotEmpty(message = "The ISBN connot be empty")
    private String ISBN;

    @NotNull(message = "The state of book's required")
    @NotEmpty(message = "The state of book connot be empty")
    private Boolean borrowed = false;
    
}
