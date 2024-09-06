package com.codingninjas.Foodies.entity;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Customer {

    private int id;

    private String name;
    // (One To Many mapping)
    private List<Rating> ratings;
    // (Many To Many mapping)
    private List<Restaurant> visitedRestaurants;

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

    public List<Restaurant> getVisitedRestaurants() {
        return visitedRestaurants;
    }

    public void setVisitedRestaurants(List<Restaurant> visitedRestaurants) {
        this.visitedRestaurants = visitedRestaurants;
    }

}
