package com.zepto.service;

import com.zepto.entites.Grocery;
import com.zepto.entites.Review;
import com.zepto.entites.User;
import com.zepto.exception.ResourceNotFoundException;
import com.zepto.repository.GroceryRepository;
import com.zepto.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final GroceryRepository groceryRepository;

    public Review giveReview(Review review
                             , long id,
                             User user){
        Grocery grocery = groceryRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("id is not present" + id));
        review.setGrocery(grocery);
        review.setUser(user);
        Review save = reviewRepository.save(review);
        return save;
    }
}
