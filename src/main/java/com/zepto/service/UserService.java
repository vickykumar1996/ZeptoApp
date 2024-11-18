package com.zepto.service;

import com.zepto.entites.User;
import com.zepto.payload.UserDto;
import com.zepto.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final JwtService jwtService;

    public Object create(User user){
        Optional<User> username = userRepo.findByUsername(user.getUsername());
        if (username .isPresent()){
            return "user name already taken";
        }
        Optional<User> byemail = userRepo.findByemail(user.getEmail());
        if (byemail.isPresent()){
            return "email id already taken";
        }
        String hashpw = BCrypt.hashpw(user.getUsername(), BCrypt.gensalt(5));
        user.setPassword(hashpw);
//        user.setRole("USER-ROLE");
         userRepo.save(user);
        return "successfully create your account";
    }
    public String veriFyLogin(UserDto userDto){
        Optional<User> username = userRepo.findByUsername(userDto.getUsername());
        if (username.isPresent()){
            User user = username.get();
            if (BCrypt.checkpw(userDto.getPassword() , user.getPassword())){
                String token = jwtService.generateToken(user.getUsername());
                return token;
            }else {
                return " pass is not match";
            }
        }else {
            return "username is not present";
        }
    }
    public List<User> getAllData(User user){
        List<User> all = userRepo.findAll();
        user.setRole("ROLE_ADMIN");
        return all;
    }
}
