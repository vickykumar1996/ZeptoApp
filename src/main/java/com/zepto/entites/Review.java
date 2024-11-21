package com.zepto.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int rating;

    private String description;

    @ManyToOne
    @JoinColumn(name = "grocery_id")
    private Grocery grocery;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}