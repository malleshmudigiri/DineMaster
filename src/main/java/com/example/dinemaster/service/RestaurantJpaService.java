/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.dinemaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.example.dinemaster.model.*;
import com.example.dinemaster.repository.*;

@Service
public class RestaurantJpaService implements RestaurantRepository {
    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;

    @Override
    public ArrayList<Restaurant> getAllRestaurants() {
        List<Restaurant> list = restaurantJpaRepository.findAll();
        ArrayList<Restaurant> arraylist = new ArrayList<>(list);
        return arraylist;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {

        restaurantJpaRepository.save(restaurant);
        return restaurant;

    }

    @Override
    public Restaurant getRestaurantById(int id) {
        try {
            Restaurant restaurant1 = restaurantJpaRepository.findById(id).get();
            return restaurant1;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteRestaurant(int id) {
        Optional<Restaurant> emptyOptional = restaurantJpaRepository.findById(id);
        if (emptyOptional.isPresent()) {
            restaurantJpaRepository.deleteById(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

    }

    @Override
    public Restaurant updateRestaurant(int id, Restaurant restaurant) {

        try {
            Restaurant restaurant123 = restaurantJpaRepository.findById(id).get();
            if (restaurant.getName() != null) {
                restaurant123.setName(restaurant.getName());
            }
            if (restaurant.getAddress() != null) {
                restaurant123.setAddress(restaurant.getAddress());
            }
            if (restaurant.getCuisineType() != null) {
                restaurant123.setCuisineType(restaurant.getCuisineType());
            }
            if (restaurant.getRating() != 0) {
                restaurant123.setRating(restaurant.getRating());
            }

            restaurantJpaRepository.save(restaurant123);
            return restaurant123;
        } catch (Exception s) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}
