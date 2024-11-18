package com.zepto.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DummyController {

    @PostMapping
    public ResponseEntity<String> getDummy(){
        return new ResponseEntity<>("Hello friends kaise Ho", HttpStatus.OK);
    }

}
