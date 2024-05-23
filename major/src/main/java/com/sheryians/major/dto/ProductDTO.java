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

    public void setId (Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return this.imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

}
