/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.dinemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.dinemaster.model.*;
import com.example.dinemaster.service.*;

@RestController
public class ChefController {
    @Autowired
    public ChefJpaService chefJpaService;

    @GetMapping("/restaurants/chefs")
    public ArrayList<Chef> getAllChef() {
        return chefJpaService.getAllChef();
    }

    @PostMapping("/restaurants/chefs")
    public Chef addChef(@RequestBody Chef chef) {
        return chefJpaService.addChef(chef);
    }

    @GetMapping("/restaurants/chefs/{id}")
    public Chef getChefById(@PathVariable("id") int id) {
        return chefJpaService.getChefById(id);

    }

    @GetMapping("/chefs/{id}/restaurant")
    public Restaurant getRestaurantById(@PathVariable("id") int id) {
        return chefJpaService.getRestaurantById(id);

    }

    @PutMapping("/restaurants/chefs/{id}")
    public Chef updateChef(@PathVariable("id") int id, @RequestBody Chef chef) {
        return chefJpaService.updateChef(id, chef);

    }

    @DeleteMapping("/restaurants/chefs/{id}")
    public void deleteChef(@PathVariable("id") int id) {
        chefJpaService.deleteChef(id);
    }
}
