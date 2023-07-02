package com.github.cleyto_orocha.library_system.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.controllers.dto.BookDTO;
import com.github.cleyto_orocha.library_system.controllers.dto.PaperDTO;
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

    public BookDTO findBookById(Long id) {
        return BookDTO.buildBookDTO(bookRepository.findById(id)
                .orElseThrow(() -> new IdError()));
    }

    public List<BookDTO> findAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(m -> BookDTO.buildBookDTO(m))
                .collect(Collectors.toList());
    }

    public Long includeBook(BookDTO bookDTO) {
        return bookRepository.save(
                BookDTO.buildBook(bookDTO))
                .getId();

    }

    public void deleteBook(Long id) {
        bookRepository.findById(id)
                .map(m -> {
                    bookRepository.delete(m);
                    return Void.TYPE;
                }).orElseThrow(() -> new IdError());
    }

    public BookDTO updateBook(BookDTO bookDTO, Long id) {
        return bookRepository.findById(id)
                .map(m -> {
                    bookDTO.setId(m.getId());
                    bookRepository.save(BookDTO.buildBook(bookDTO));
                    return bookDTO;
                }).orElseThrow(() -> new IdError());
    }

    // Paper Service

    public PaperDTO findPaperById(Long id) {
        return PaperDTO.buildPaperDTO(paperRepository.findById(id)
                .orElseThrow(() -> new IdError()));
    }

    public List<PaperDTO> findAllPaper() {
        return paperRepository.findAll()
                .stream()
                .map(m -> PaperDTO.buildPaperDTO(m))
                .collect(Collectors.toList());
    }

    public Long includePaper(PaperDTO paperDTO) {
        return paperRepository.save(
                PaperDTO.buildPaper(paperDTO))
                .getId();
    }

    public void deletePaper(Long id) {
        paperRepository.findById(id)
                .map(m -> {
                    paperRepository.delete(m);
                    return Void.TYPE;
                }).orElseThrow(() -> new IdError());
    }

    public PaperDTO updatePaper(PaperDTO paperDTO, Long id) {
        return paperRepository.findById(id)
                .map(m -> {
                    paperDTO.setId(m.getId());
                    paperRepository.save(PaperDTO.buildPaper(paperDTO));
                    return paperDTO;
                }).orElseThrow(() -> new IdError());
    }

}
