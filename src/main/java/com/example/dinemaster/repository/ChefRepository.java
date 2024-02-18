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

public interface ChefRepository {
      ArrayList<Chef> getAllChef();

      Chef addChef(Chef chef);

      Chef getChefById(int id);

      Chef updateChef(int id, Chef chef);

      Restaurant getRestaurantById(int id);

      void deleteChef(int id);

}
