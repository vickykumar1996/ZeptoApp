package com.zepto.controller;

import com.zepto.payload.GroceryDto;
import com.zepto.service.GroceryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/grocery")
public class GroceryController {

    private final GroceryService groceryService;

    @PostMapping
    public ResponseEntity<GroceryDto> saveGrocery(@RequestBody GroceryDto groceryDto){
        GroceryDto saveGroceryItem = groceryService.saveGrocery(groceryDto);
        return new ResponseEntity<>(saveGroceryItem, HttpStatus.OK);
    }


}
