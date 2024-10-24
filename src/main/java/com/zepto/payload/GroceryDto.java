package com.zepto.payload;

import jakarta.persistence.Column;
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
    @Positive(message = "Grocery quantity must be positive")
    private long geroceryQuantity;
    @NotBlank(message = "Country of origin is required")
    private String countryOrgin;
    @NotBlank(message = "Manufacturer name is required")
    private String manufacturerName;
    @NotBlank(message = "Product Address is required")
    private String productAddress;
    @Size(max = 300 ,message = "About sec tion must not exceed 300 charcters")
    private String about;
}
