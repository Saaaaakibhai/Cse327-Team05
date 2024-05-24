package com.sheryians.major.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Category is an entity representing a product category in the system.
 */
@Entity
@Data
public class Category {
    private int id;
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    
}