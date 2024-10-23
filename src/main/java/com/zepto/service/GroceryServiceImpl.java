package com.zepto.service;

import com.zepto.entites.Grocery;
import com.zepto.exception.ResourceNotFoundException;
import com.zepto.payload.GroceryDto;
import com.zepto.repository.GroceryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GroceryServiceImpl implements GroceryService {
    private final GroceryRepository repository;
    private final ModelMapper mapper;

    @Override

    public GroceryDto saveGrocery(GroceryDto groceryDto) {
        Grocery save = repository.save(mapToEntity(groceryDto));
        GroceryDto groceryDto1 = mapToDto(save);
        return groceryDto1;
    }

    @Override
    public List<GroceryDto> ListAllData() {
        List<Grocery> all = repository.findAll();
        List<GroceryDto> list = all.stream().map(a -> mapToDto(a)).toList();
        return list;
    }

    @Override
    public GroceryDto getGroceryById(long id) {
        Optional<Grocery> optionalGrocery = repository.findById(id);
        if (optionalGrocery.isPresent()) {
            return mapToDto(optionalGrocery.get());
        } else {
            throw new ResourceNotFoundException("Grocery not found with id: " + id);
        }
    }


    @Override
    public void deleteReg(long id) {
     repository.deleteById(id);
    }

    @Override
    public GroceryDto updateReg(long id, GroceryDto dto) {
        return null;
    }

    public GroceryDto mapToDto(Grocery grocery) {
        GroceryDto map = mapper.map(grocery, GroceryDto.class);
        return map;
    }

    public Grocery mapToEntity(GroceryDto groceryDto) {
        Grocery map = mapper.map(groceryDto, Grocery.class);
        return map;
    }
}
