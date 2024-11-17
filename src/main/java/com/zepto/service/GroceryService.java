package com.zepto.service;


import com.zepto.entites.Grocery;
import com.zepto.payload.GroceryDto;

import java.util.List;

public interface GroceryService {
    GroceryDto saveGrocery(GroceryDto groceryDto);
    public List<GroceryDto>ListAllData();

    GroceryDto getGroceryById(long id);

    public void deleteReg (long id);
    public Grocery updateReg(long id , GroceryDto dto);
}
