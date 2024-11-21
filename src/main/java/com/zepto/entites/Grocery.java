package com.zepto.entites;

import com.zepto.payload.UserInfoDto;
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

    @Column(name = "grocery_name")
    private String groceryName;

    @Column(name = "grocery_price", nullable = false)
    private double groceryPrice;

    @Column(name = "manufacturer_name", nullable = false)
    private String manufacturerName;


    @Column(name = "about")
    private String about;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}