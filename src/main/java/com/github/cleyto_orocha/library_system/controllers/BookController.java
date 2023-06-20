package com.github.cleyto_orocha.library_system.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cleyto_orocha.library_system.entities.Book;
import com.github.cleyto_orocha.library_system.entities.Product;
import com.github.cleyto_orocha.library_system.services.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products/books")
public class BookController {

    private final BookService bookService;

    @PostMapping("/books")
    public Book includeBook(@RequestBody @Valid Book book) {
        return bookService.includeBook(book);
    }

    @GetMapping("/books")
    public List<Product> findAllBooks() {
        return bookService.findAllBooks();
    }
}
