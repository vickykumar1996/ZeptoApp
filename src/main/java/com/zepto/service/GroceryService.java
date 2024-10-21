package com.zepto.service;


import com.zepto.payload.GroceryDto;

import java.util.List;

public interface GroceryService {
    GroceryDto saveGrocery(GroceryDto groceryDto);
    public List<GroceryDto>ListAllData();
    public void deleteReg (long id);
    public GroceryDto updateReg(long id , GroceryDto dto);
}
