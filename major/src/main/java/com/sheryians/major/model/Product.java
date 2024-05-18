package com.sheryians.major.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Product is an entity representing a product in the system.
 */
@Entity
@Data
public class Product {

    /**
     * The unique identifier of the product.
     * It is generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The name of the product.
     */
    private String name;

    /**
     * The category to which the product belongs.
     * It is fetched lazily.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

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
