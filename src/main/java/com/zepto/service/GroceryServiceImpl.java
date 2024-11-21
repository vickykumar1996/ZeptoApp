package com.zepto.service;

import com.zepto.entites.City;
import com.zepto.entites.Country;
import com.zepto.entites.Grocery;
import com.zepto.exception.ResourceNotFoundException;
import com.zepto.payload.GroceryDto;
import com.zepto.repository.CityRepository;
import com.zepto.repository.CountryRepository;
import com.zepto.repository.GroceryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GroceryServiceImpl implements GroceryService {
    private final GroceryRepository repository;
    private final ModelMapper mapper;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Override

    @Transactional
    public GroceryDto saveGrocery(GroceryDto groceryDto ) {
        City city = cityRepository.save(groceryDto.getCity());
        Country country = countryRepository.save(groceryDto.getCountry());
        Grocery grocery = mapToEntity(groceryDto);
        grocery.setCountry(country);
        grocery.setCity(city);
        Grocery save = repository.save(grocery);
        return mapToDto(save);

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
    public Grocery searchByName(String searchValue){
        Grocery groceries = repository.searchByNameCityOrCountry(searchValue)
                .orElseThrow(()-> new ResourceNotFoundException("groseryName is not fount  "  + searchValue));
        return groceries;
    }

    @Override
    public void deleteReg(long id) {
        Grocery byId = repository.findById(id).orElseThrow(()-> new NoSuchElementException("id not found"));
        repository.delete(byId);
    }

    @Override
    public Grocery updateReg(long id, GroceryDto dto) {
        Grocery present = repository.findById(id).orElseThrow(() -> new NoSuchElementException ("id is not presents"));
        present.setGroceryName(dto.getGroceryName());
        present.setAbout(dto.getAbout());
        present.setGroceryPrice(dto.getGroceryPrice());
//        present.setCountry(dto.getCountry());
        present.setManufacturerName(dto.getManufacturerName());
//        present.setCity(dto.getCity());
        Grocery saved = repository.save(present);
      return saved;
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
