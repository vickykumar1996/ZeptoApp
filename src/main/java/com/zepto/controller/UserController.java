package com.zepto.controller;

import com.zepto.entites.User;
import com.zepto.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/security")
public class UserController {

    private final UserService userService;

    @PostMapping
    public Object create(@RequestBody User user){
        Object object = userService.create(user);
        return object;

    }

}
