package com.zepto.payload;

import com.zepto.entites.City;
import com.zepto.entites.Country;
import com.zepto.entites.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroceryDto {
    private Long id;
    @NotBlank(message = "Grocery name is required")
    @Size(min = 2, max = 50, message = "Grocery name must be between 2 and 50 Characters")
    private String groceryName;
    @Positive(message = "Grocery price must be Positive")
    private double groceryPrice;
    @NotBlank(message = "Country of origin is required")
    private String manufacturerName;
    @NotBlank(message = "Product Address is required")
    private String about;

    private User user;

    private Country country;

    private City city;
}
