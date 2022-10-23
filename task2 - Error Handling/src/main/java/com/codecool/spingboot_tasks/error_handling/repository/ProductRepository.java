package com.codecool.spingboot_tasks.error_handling.repository;

import com.codecool.spingboot_tasks.error_handling.exceptions.ProductNotFoundException;
import com.codecool.spingboot_tasks.error_handling.model.Product;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private String errorMSG;

    public List<Product> findAll(){
        throw new IllegalStateException();
    }

    public List<Product> findById(long id) throws ProductNotFoundException {
        throw new ProductNotFoundException("There is no product with id: " + id);
    }


}
