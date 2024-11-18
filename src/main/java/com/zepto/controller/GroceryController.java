package com.zepto.controller;

import com.zepto.entites.Grocery;
import com.zepto.entites.User;
import com.zepto.payload.GroceryDto;
import com.zepto.payload.UserInfoDto;
import com.zepto.service.GroceryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/grocery")
public class GroceryController {

    private final GroceryService groceryService;

    @PostMapping
    public ResponseEntity<GroceryDto> saveGrocery(@Valid @RequestBody GroceryDto groceryDto , @AuthenticationPrincipal User user){
        groceryDto.setUser(user);
        GroceryDto saveGroceryItem = groceryService.saveGrocery(groceryDto);
        return new ResponseEntity<>(saveGroceryItem, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<GroceryDto>>getAllData(){
        List<GroceryDto> groceryDtos = groceryService.ListAllData();
        return new ResponseEntity<>(groceryDtos , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<GroceryDto> getGroceryById(@PathVariable Long id){
        GroceryDto groceryById = groceryService.getGroceryById(id);
        return new ResponseEntity<>(groceryById,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReg(@PathVariable long id){
        groceryService.deleteReg(id);
        return  new ResponseEntity<>("data is deleted",HttpStatus.OK);
    }

    public ResponseEntity<Grocery>Update(@PathVariable Long id,@RequestBody GroceryDto groceryDto){
        Grocery grocery = groceryService.updateReg(id, groceryDto);
        return ResponseEntity.ok(grocery);
    }
}
