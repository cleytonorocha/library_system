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

    @Deprecated
    public void deleteProduct(Long id) {
        productRepository.findById(id)
                .map(m -> {
                    productRepository.delete(m);
                    return Void.TYPE;
                }).orElseThrow(() -> new IdError());
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

    public void deleteBook(Long id) {
        bookRepository.findById(id)
                .map(m -> {
                    bookRepository.delete(m);
                    return Void.TYPE;
                }).orElseThrow(() -> new IdError());
    }

    public Book updateBook(Book book, Long id) {
        return bookRepository.findById(id)
                .map(m -> {
                    book.setId(m.getId());
                    bookRepository.save(book);
                    return book;
                }).orElseThrow(() -> new IdError());
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

    public void deletePaper(Long id) {
        paperRepository.findById(id)
                .map(m -> {
                    paperRepository.delete(m);
                    return Void.TYPE;
                }).orElseThrow(() -> new IdError());
    }

    public Paper updatePaper(Paper paper, Long id) {
        return paperRepository.findById(id)
                .map(m -> {
                    paper.setId(m.getId());
                    paperRepository.save(paper);
                    return paper;
                }).orElseThrow(() -> new IdError());
    }

    
}
