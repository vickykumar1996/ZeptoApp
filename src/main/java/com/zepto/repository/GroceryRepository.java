package com.zepto.repository;

import com.zepto.entites.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface GroceryRepository extends JpaRepository<Grocery, Long> {
    @Query("SELECT g FROM Grocery g " +
            "JOIN g.city c " +
            "JOIN g.country co " +
            "WHERE g.groceryName = :searchValue " +
            "OR c.name = :searchValue " +
            "OR co.name = :searchValue")
    Optional<Grocery> searchByNameCityOrCountry(@Param("searchValue") String searchValue);
}
