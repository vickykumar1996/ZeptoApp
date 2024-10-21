package com.zepto.service;

import com.zepto.payload.GroceryDto;
import com.zepto.repository.GroceryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class GroceryServiceImpl implements GroceryService{
    private  final GroceryRepository repository;
    @Override

    public GroceryDto saveGrocery(GroceryDto groceryDto) {
        return null;
    }

    @Override
    public List<GroceryDto> ListAllData() {

    }

    @Override
    public void deleteReg(long id) {

    }

    @Override
    public GroceryDto updateReg(long id, GroceryDto dto) {
        return null;
    }
}
