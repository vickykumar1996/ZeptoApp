package com.zepto.payload;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroceryDto {
    private Long id;
    private String groceryName;
    private double groceryPrice;
    private long geroceryQuantity;
    private String countryOrgin;
    private String manufacturerName;
    private String productAddress;
    private String about;
}
