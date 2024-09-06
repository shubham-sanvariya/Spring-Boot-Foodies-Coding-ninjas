package com.codingninjas.Foodies.entity;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Restaurant {
    private int id;

    private String name;

    // (One To Many mapping)
    private List<Rating> ratings;

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

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

}
