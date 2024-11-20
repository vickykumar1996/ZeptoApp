package com.zepto.repository;

import com.zepto.entites.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface GroceryRepository extends JpaRepository<Grocery, Long> {
    @Query("SELECT g FROM Grocery g WHERE g.groceryName = :grocery_name")
    Optional<Grocery> searchGrocery(@Param("grocery_name") String groceryName);
}
