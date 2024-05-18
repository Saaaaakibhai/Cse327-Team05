package com.sheryians.major.dto;

import lombok.Data;

/**
 * ProductDTO is a Data Transfer Object for Product.
 * It is used to transfer product data between different parts of the application.
 */
@Data
public class ProductDTO {
    /**
     * The unique identifier of the product.
     */
    private Long id;

    /**
     * The name of the product.
     */
    private String name;

    /**
     * The identifier of the category to which the product belongs.
     */
    private int categoryId;

    /**
     * The price of the product.
     */
    private double price;

    /**
     * The weight of the product.
     */
    private double weight;

    /**
     * A description of the product.
     */
    private String description;

    /**
     * The name of the image associated with the product.
     */
    private String imageName;
}
