package com.codingninjas.Foodies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Rating;
import com.codingninjas.Foodies.entity.Restaurant;
import com.codingninjas.Foodies.service.MainService;

@RestController
public class MainController {
    @Autowired
    MainService mainService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return mainService.getAllCustomers();
    }

    @GetMapping("/ratings")
    public List<Rating> getAllRatings(){
        return mainService.getAllRatings();
    }

    @PostMapping("/Customer/add")
    public void addCustomer(@RequestBody Customer customer){
        mainService.addCustomer(customer);
    }
}
