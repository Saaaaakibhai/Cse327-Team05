package com.sheryians.major.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Category is an entity representing a product category in the system.
 */
@Entity
@Data
public class Category {

    /**
     * The unique identifier of the category.
     * It is generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int id;

    /**
     * The name of the category.
     */
    private String name;
}
