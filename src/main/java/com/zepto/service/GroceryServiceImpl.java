package com.zepto.service;

import com.zepto.payload.GroceryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryServiceImpl implements GroceryService{
    @Override
    public GroceryDto saveGrocery(GroceryDto groceryDto) {
        return null;
    }

    @Override
    public List<GroceryDto> ListAllData() {
        return List.of();
    }

    @Override
    public void deleteReg(long id) {

    }

    @Override
    public GroceryDto updateReg(long id, GroceryDto dto) {
        return null;
    }
}
