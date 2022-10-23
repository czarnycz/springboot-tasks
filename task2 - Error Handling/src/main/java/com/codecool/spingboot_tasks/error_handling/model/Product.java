package com.codecool.spingboot_tasks.error_handling.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Product {
    private final Long id;
    private final String name;
    private final int price;
}
