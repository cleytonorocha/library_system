package com.github.cleyto_orocha.library_system.controllers.dto;

import java.time.Instant;
import java.util.stream.Collectors;

import org.hibernate.validator.constraints.ISBN;

import com.github.cleyto_orocha.library_system.entities.Book;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(example = "CleytonTor")
    @NotNull(message = "The author name's required")
    @NotEmpty(message = "The author name connot be empty")
    private String author;

    @Schema(example = "Publish of Cleyton")
    @NotNull(message = "The publisher name's required")
    @NotEmpty(message = "The publisher name connot be empty")
    private String publisher;

    @Past
    @NotNull(message = "The data of book's required")
    private Instant data;

    @ISBN
    @Schema(example = "9789898839664")
    @NotNull(message = "The ISBN's required")
    @NotEmpty(message = "The ISBN connot be empty")
    private String isbn;

    @NotNull(message = "The state of book's required")
    @Schema(example = "true")
    private Boolean borrowed;

    public static BookDTO buildBookDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .name(book.getName())
                .codBarr(book.getCodBarr())
                .type(book.getType())
                .price(book.getPrice())
                .listClientsdClientDTO(book.getListClients()
                        .stream()
                        .map(ClientDTO::buildClientDTO)
                        .toList())
                .operations(book.getOperations()
                        .stream()
                        .map(AcquisitionDTO::buildAcquisitionDTO)
                        .collect(Collectors.toSet()))
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .data(book.getData())
                .isbn(book.getIsbn())
                .borrowed(book.getBorrowed())
                .build();
    }

    public static Book buildBook(BookDTO bookDTO) {
        return Book.builder()
                .id(bookDTO.getId())
                .name(bookDTO.getName())
                .codBarr(bookDTO.getCodBarr())
                .type(bookDTO.getType())
                .price(bookDTO.getPrice())
                .author(bookDTO.getAuthor())
                .publisher(bookDTO.getPublisher())
                .data(bookDTO.getData())
                .isbn(bookDTO.getIsbn())
                .borrowed(bookDTO.getBorrowed())
                .build();
    }

}
