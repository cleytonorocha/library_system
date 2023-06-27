package com.github.cleyto_orocha.library_system.controllers.dto;

import java.time.Instant;

import org.hibernate.validator.constraints.ISBN;

import com.github.cleyto_orocha.library_system.entities.Book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO extends ProductDTO {

    @NotNull(message = "The author name's required")
    @NotEmpty(message = "The author name connot be empty")
    private String author;

    @NotNull(message = "The publisher name's required")
    @NotEmpty(message = "The publisher name connot be empty")
    private String publisher;

    @Past
    @NotNull(message = "The data of book's required")
    private Instant data;

    @ISBN
    @NotNull(message = "The ISBN's required")
    @NotEmpty(message = "The ISBN connot be empty")
    private String ISBN;

    @NotNull(message = "The state of book's required")
    private Boolean borrowed;
    
    public static BookDTO buildBookDTO(Book book){
        return BookDTO.builder()
        .id(book.getId())
        .name(book.getName())
        .codBarr(book.getCodBarr())
        .type(book.getType())
        .price(book.getPrice())
        .listClients(book.getListClients())
        .operations(book.getOperations())
        .author(book.getAuthor())
        .publisher(book.getPublisher())
        .data(book.getData())
        .ISBN(book.getISBN())
        .borrowed(book.getBorrowed())
        .build();
    }

    public static Book buildBook(BookDTO bookDTO){
        return Book.builder()
        .id(bookDTO.getId())
        .name(bookDTO.getName())
        .codBarr(bookDTO.getCodBarr())
        .type(bookDTO.getType())
        .price(bookDTO.getPrice())
        .listClients(bookDTO.getListClients())
        .operations(bookDTO.getOperations())
        .author(bookDTO.getAuthor())
        .publisher(bookDTO.getPublisher())
        .data(bookDTO.getData())
        .ISBN(bookDTO.getISBN())
        .borrowed(bookDTO.getBorrowed())
        .build();
    }

}
