/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.dinemaster.repository;

import java.util.ArrayList;
import com.example.dinemaster.model.*;

public interface RestaurantRepository {
      ArrayList<Restaurant> getAllRestaurants();

      Restaurant addRestaurant(Restaurant restaurant);

      Restaurant getRestaurantById(int id);

      Restaurant updateRestaurant(int id, Restaurant restaurant);

      void deleteRestaurant(int id);

}
