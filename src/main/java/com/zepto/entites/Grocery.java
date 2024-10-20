package com.zepto.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "grocery")
public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Aditya_name")
    private String groceryName;

    @Column(name = "grocery_price", nullable = false)
    private double groceryPrice;

    @Column(name = "gerocery_quantity", nullable = false)
    private long geroceryQuantityy;

    @Column(name = "country_orgin")
    private String countryOrgin;

    @Column(name = "manufacturer_name", nullable = false)
    private String manufacturerName;

    @Column(name = "product_address", nullable = false)
    private String productAddress;

    @Column(name = "about")
    private String about;

}