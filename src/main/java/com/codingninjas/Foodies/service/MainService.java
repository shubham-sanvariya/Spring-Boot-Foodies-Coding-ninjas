package com.codingninjas.Foodies.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Rating;
import com.codingninjas.Foodies.entity.Restaurant;
import com.codingninjas.Foodies.repository.CustomerRepository;
import com.codingninjas.Foodies.repository.RatingRepository;
import com.codingninjas.Foodies.repository.RestaurantRepository;

@Service
public class MainService {
    
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RatingRepository ratingRepository;

    public List<Rating> getAllRatings(){
        return ratingRepository.findAll();
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void addRestaurant(Restaurant restaurant){
        restaurantRepository.save(restaurant);
    }

    public void  addRatingForRestaurantByCustomer(Rating rating, Integer customerId, String restaurantName){
        Restaurant restaurant = restaurantRepository.findByName(restaurantName);
        if (restaurant == null) {
            throw new NoSuchElementException("no such restaurant by restaurant name: " + restaurantName);
        }

        Customer customer = customerRepository.findById(customerId)
        .orElseThrow(() -> new NoSuchElementException("customer not found by customer id: " + customerId));

        rating.setRestaurant(restaurant);
        rating.setCustomer(customer);
        ratingRepository.save(rating);

        restaurant.getRatings().add(rating);
        customer.getRatings().add(rating);

        restaurantRepository.save(restaurant);
        customerRepository.save(customer);
    }
}
