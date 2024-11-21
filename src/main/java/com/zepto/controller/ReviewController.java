package com.zepto.controller;

import com.zepto.entites.Review;
import com.zepto.entites.User;
import com.zepto.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vi/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/give-review")
    public ResponseEntity<?>createReview(@RequestBody Review review ,
                                         @RequestParam long id ,
                                         @AuthenticationPrincipal User user){
        Review giveReview = reviewService.giveReview(review, id, user);
        return new ResponseEntity<>(giveReview , HttpStatus.CREATED);
    }
}
