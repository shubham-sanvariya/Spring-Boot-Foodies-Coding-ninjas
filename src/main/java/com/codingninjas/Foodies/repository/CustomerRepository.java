package com.codingninjas.Foodies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Restaurant;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // @Query(value = "SELECT * FROM customer c " +
    //         "JOIN customer_restaurant cr ON c.id = cr.customer_id " +
    //         "WHERE cr.restaurant_id = :restaurantId", nativeQuery = true)
    // it need restaurantId as params 
    
    // @Query("SELECT c FROM Customer c WHERE :restaurant MEMBER OF c.visitedRestaurants")
    List<Customer> findByVisitedRestaurants(Restaurant restaurant);
}
