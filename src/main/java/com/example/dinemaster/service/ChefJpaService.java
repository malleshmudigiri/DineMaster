/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
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

import com.example.dinemaster.repository.*;

import com.example.dinemaster.model.*;

@Service
public class ChefJpaService implements ChefRepository {
    @Autowired
    private ChefJpaRepository chefJpaRepository;
    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;

    @Override
    public ArrayList<Chef> getAllChef() {
        List<Chef> list = chefJpaRepository.findAll();
        ArrayList<Chef> arraylist = new ArrayList<>(list);
        return arraylist;
    }

    @Override
    public Chef addChef(Chef chef) {
        try {

            Restaurant restaurant = chef.getRestaurant();
            int reustarantId = restaurant.getId();
            Restaurant newRestaurant = restaurantJpaRepository.findById(reustarantId).get();
            chef.setRestaurant(newRestaurant);

            chefJpaRepository.save(chef);
            return chefJpaRepository.findById(chef.getId()).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

    }

    @Override
    public Chef getChefById(int id) {
        try {
            Chef chef = chefJpaRepository.findById(id).get();
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteChef(int id) {
        Optional<Chef> emptyOptional = chefJpaRepository.findById(id);

        if (emptyOptional.isPresent()) {

            chefJpaRepository.deleteById(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override

    public Restaurant getRestaurantById(int id) {
        try {
            Chef chef = chefJpaRepository.findById(id).get();
            Restaurant restaurant = chef.getRestaurant();
            int restaurantId = restaurant.getId();
            Restaurant restaurant1 = restaurantJpaRepository.findById(restaurantId).get();
            return restaurant1;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Chef updateChef(int id, Chef chef) {
        try {
            Chef newChef = chefJpaRepository.findById(id).get();
            if (chef.getFirstName() != null) {
                newChef.setFirstName(chef.getFirstName());
            }
            if (chef.getLastName() != null) {
                newChef.setLastName(chef.getLastName());
            }
            if (chef.getExpertise() != null) {
                newChef.setExpertise(chef.getExpertise());

            }
            if (chef.getExperienceYears() != 0) {
                newChef.setExperienceYears(chef.getExperienceYears());
            }
            if (chef.getRestaurant() != null) {
                Restaurant restaurant = chef.getRestaurant();
                int restaurantId = restaurant.getId();
                Restaurant restaurant1 = restaurantJpaRepository.findById(restaurantId).get();
                newChef.setRestaurant(restaurant1);

            }
            chefJpaRepository.save(newChef);
            return newChef;
        } catch (Exception s) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}
