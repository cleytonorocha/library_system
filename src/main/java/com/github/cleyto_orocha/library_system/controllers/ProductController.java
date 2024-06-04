package com.github.cleyto_orocha.library_system.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cleyto_orocha.library_system.controllers.dto.BookDTO;
import com.github.cleyto_orocha.library_system.controllers.dto.PaperDTO;
import com.github.cleyto_orocha.library_system.entities.Product;
import com.github.cleyto_orocha.library_system.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    // Product Controller

    @Operation(summary = "Get a product by id")
    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @Operation(summary = "Get all products")
    @GetMapping
    public List<Product> findAllProduct() {
        return productService.findAllProducts();
    }

    // @DeleteMapping("/{id}")
    // public void deleteProduct(@PathVariable Long id) {
    //     productService.deleteProduct(id);
    // }

    // Books Controller

    @Operation(summary = "Get a book by id")
    @GetMapping("/books/{id}")
    public BookDTO findBookById(@PathVariable Long id) {
        return productService.findBookById(id);
    }

    @Operation(summary = "Save a book")
    @PostMapping("/books")
    public long includeBook(@RequestBody @Valid BookDTO bookDTO) {
        return productService.includeBook(bookDTO);
    }

    @Operation(summary = "Get all books")
    @GetMapping("/books")
    public List<BookDTO> findAllBooks() {
        return productService.findAllBooks();
    }

    @Operation(summary = "Delete a book by id")
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        productService.deleteBook(id);
    }

    @Operation(summary = "Update a book by id")
    @PutMapping("/books/{id}")
    public BookDTO updateBook(@PathVariable @Valid Long id, @RequestBody BookDTO bookDTO) {
        return productService.updateBook(bookDTO, id);
    }

    // Paper Controller

    @Operation(summary = "Get a paper by id")
    @GetMapping("/papers/{id}")
    public PaperDTO findPaperById(@PathVariable Long id) {
        return productService.findPaperById(id);
    }

    @Operation(summary = "Get all papers")
    @GetMapping("/papers")
    public List<PaperDTO> findAllPaper() {
        return productService.findAllPaper();
    }

    @Operation(summary = "Save a paper")
    @PostMapping("/papers")
    public long includePaper(@RequestBody @Valid PaperDTO paperDTO) {
        return productService.includePaper(paperDTO);
    }

    @Operation(summary = "Delete a paper by id")
    @DeleteMapping("/papers/{id}")
    public void deletePaper(@PathVariable Long id) {
        productService.deletePaper(id);
    }

    @Operation(summary = "Update a paper by id")
    @PutMapping("/papers/{id}")
    public PaperDTO updateBook(@PathVariable @Valid Long id, @RequestBody PaperDTO paperDTO) {
        return productService.updatePaper(paperDTO, id);
    }

}
