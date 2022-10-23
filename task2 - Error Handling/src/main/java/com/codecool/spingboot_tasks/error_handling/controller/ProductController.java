package com.codecool.spingboot_tasks.error_handling.controller;

import com.codecool.spingboot_tasks.error_handling.exceptions.ProductCreateException;
import com.codecool.spingboot_tasks.error_handling.exceptions.ProductNotFoundException;
import com.codecool.spingboot_tasks.error_handling.model.BackendError;
import com.codecool.spingboot_tasks.error_handling.model.Product;
import com.codecool.spingboot_tasks.error_handling.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public List<Product> getProducts(@PathVariable long id) throws ProductNotFoundException {
        return productService.getProduct(id);
    }
    @ExceptionHandler(Exception.class)
    //@ExceptionHandler({ ProductCreateException.class, ProductCreateException2.class })
    public ResponseEntity<BackendError> handleProductCreateException() {
        log.info("Pojawil sie exception");
        return ResponseEntity.badRequest().body(new BackendError("zly request",1));
    }
}
