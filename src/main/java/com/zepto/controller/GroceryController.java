package com.zepto.controller;

import com.zepto.payload.GroceryDto;
import com.zepto.service.GroceryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/grocery")
public class GroceryController {

    private final GroceryService groceryService;

    public ResponseEntity<GroceryDto> saveGrocery(@RequestBody GroceryDto groceryDto){
        groceryService.saveGrocery()
    }


    @GetMapping
    public ResponseEntity<List<GroceryDto>>getAllData(){
        List<GroceryDto> groceryDtos = groceryService.ListAllData();
        return new ResponseEntity<>(groceryDtos , HttpStatus.OK);
    }

}
