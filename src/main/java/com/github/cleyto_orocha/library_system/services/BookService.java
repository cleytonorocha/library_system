package com.github.cleyto_orocha.library_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.entities.Book;
import com.github.cleyto_orocha.library_system.entities.Product;
import com.github.cleyto_orocha.library_system.exception.IdError;
import com.github.cleyto_orocha.library_system.repositories.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Product> findAllBooks() {
        return bookRepository.findAll();
    }

    public Product findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new IdError());
    }

    public Book includeBook(Book book) {
        return bookRepository.save(book);
    }
}
