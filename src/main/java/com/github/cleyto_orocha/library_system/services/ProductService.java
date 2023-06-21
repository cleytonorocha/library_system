package com.github.cleyto_orocha.library_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.entities.Book;
import com.github.cleyto_orocha.library_system.entities.Paper;
import com.github.cleyto_orocha.library_system.entities.Product;
import com.github.cleyto_orocha.library_system.exception.IdError;
import com.github.cleyto_orocha.library_system.repositories.BookRepository;
import com.github.cleyto_orocha.library_system.repositories.PaperRepository;
import com.github.cleyto_orocha.library_system.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final PaperRepository paperRepository;
    private final BookRepository bookRepository;
    private final ProductRepository productRepository;

    // Product Service

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IdError());
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    // Book Service

    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new IdError());
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book includeBook(Book book) {
        return bookRepository.save(book);
    }

    // Paper Service

    public Paper findPaperById(Long id) {
        return paperRepository.findById(id).orElseThrow(() -> new IdError());
    }

    public List<Paper> findAllPaper() {
        return paperRepository.findAll();
    }

    public Paper includePaper(Paper Paper) {
        return paperRepository.save(Paper);
    }
}
