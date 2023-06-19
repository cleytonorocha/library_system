package com.github.cleyto_orocha.library_system.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "idProduct")
public class Book extends Product {

    @Column(length = 200)
    @NotNull(message = "The author name's required")
    private String author;

    @Column(length = 100)
    @NotNull(message = "The publisher name's required")
    @NotEmpty(message = "The publisher name connot be empty")
    private String publisher;

    @Column(length = 100)
    @NotNull(message = "The data of book's required")
    private Instant data;

    private String ISBN;

    private Boolean borrowed = false;

    // public Book(Long idProduct, String name, String codBarr, Integer type, BigDecimal price, String author, String publisher, Instant data, String ISBN) {
    //     super(idProduct, name, codBarr, type, price);
    //     this.author = author;
    //     this.publisher = publisher;
    //     this.data = data;
    //     this.ISBN = ISBN;
    // }
}
