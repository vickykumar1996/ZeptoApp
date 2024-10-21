package com.zepto.repository;

import com.zepto.entites.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryRepository  extends JpaRepository<Grocery,Long> {

}
