package com.zepto.controller;

import com.zepto.entites.User;
import com.zepto.payload.TokenDto;
import com.zepto.payload.UserDto;
import com.zepto.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public Object create(@RequestBody User user){
        Object object = userService.create(user);
        return object;

    }
    @PostMapping("/login")
    public ResponseEntity<?>veryFiToken(@RequestBody UserDto userDto){
        String token = userService.veriFyLogin(userDto);
        if (token!=null){
            TokenDto tokenDto = new TokenDto();
            tokenDto.setToken(token);
            tokenDto.setType("Jwt Type");
            return new ResponseEntity<>(tokenDto , HttpStatus.OK);
        }else {
            return new ResponseEntity<>("id pass is incorrect please provide valid id and password",
                    HttpStatus.BAD_REQUEST);
        }
    }

}
