package com.github.cleyto_orocha.library_system.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.github.cleyto_orocha.library_system.enums.SwaggerEnum;
import com.github.cleyto_orocha.library_system.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
@Tag(name = SwaggerEnum.PRODUCT_TAG_NAME, description = SwaggerEnum.PRODUCT_TAG_DESCRIPTION)
public class ProductController {

    private final ProductService productService;

    // Product Controller

    @Operation(summary = "Get a product by id")
    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product = productService.findProductById(id);
        return ResponseEntity.ok().body(product);
    }

    @Operation(summary = "Get all products")
    @GetMapping
    public ResponseEntity<List<Product>> findAllProduct() {
        List<Product> products = productService.findAllProducts();
        return ResponseEntity.ok().body(products);
    }

    // Books Controller

    @Operation(summary = "Get a book by id")
    @GetMapping("/books/{id}")
    public ResponseEntity<BookDTO> findBookById(@PathVariable Long id) {
        BookDTO book = productService.findBookById(id);
        return ResponseEntity.ok().body(book);
    }

    @Operation(summary = "Save a book")
    @PostMapping("/books")
    public ResponseEntity<Long> includeBook(@RequestBody @Valid BookDTO bookDTO) {
        Long bookId = productService.includeBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookId);
    }

    @Operation(summary = "Get all books")
    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> findAllBooks() {
        List<BookDTO> books = productService.findAllBooks();
        return ResponseEntity.ok().body(books);
    }

    @Operation(summary = "Delete a book by id")
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        productService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update a book by id")
    @PutMapping("/books/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable @Valid Long id, @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = productService.updateBook(bookDTO, id);
        return ResponseEntity.ok().body(updatedBook);
    }

    // Paper Controller

    @Operation(summary = "Get a paper by id")
    @GetMapping("/papers/{id}")
    public ResponseEntity<PaperDTO> findPaperById(@PathVariable Long id) {
        PaperDTO paper = productService.findPaperById(id);
        return ResponseEntity.ok().body(paper);
    }

    @Operation(summary = "Get all papers")
    @GetMapping("/papers")
    public ResponseEntity<List<PaperDTO>> findAllPaper() {
        List<PaperDTO> papers = productService.findAllPaper();
        return ResponseEntity.ok().body(papers);
    }

    @Operation(summary = "Save a paper")
    @PostMapping("/papers")
    public ResponseEntity<Long> includePaper(@RequestBody @Valid PaperDTO paperDTO) {
        Long paperId = productService.includePaper(paperDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(paperId);
    }

    @Operation(summary = "Delete a paper by id")
    @DeleteMapping("/papers/{id}")
    public ResponseEntity<Void> deletePaper(@PathVariable Long id) {
        productService.deletePaper(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update a paper by id")
    @PutMapping("/papers/{id}")
    public ResponseEntity<PaperDTO> updatePaper(@PathVariable @Valid Long id, @RequestBody PaperDTO paperDTO) {
        PaperDTO updatedPaper = productService.updatePaper(paperDTO, id);
        return ResponseEntity.ok().body(updatedPaper);
    }

}
