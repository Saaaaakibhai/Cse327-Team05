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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}