package com.github.cleyto_orocha.library_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.entities.Book;
import com.github.cleyto_orocha.library_system.entities.Product;
import com.github.cleyto_orocha.library_system.exception.IdError;
import com.github.cleyto_orocha.library_system.repositories.BookRepository;
import com.github.cleyto_orocha.library_system.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;
    private final BookRepository bookRepository;

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new IdError());
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }


    // public Book findBookById(Long id) {
    //     return bookRepository.findById(id).orElseThrow(() -> new IdError());
    // }

    public Book includeBook(Book book){
        return bookRepository.save(book);
    }

    
    
}
