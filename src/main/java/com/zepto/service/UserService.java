package com.zepto.service;

import com.zepto.entites.User;
import com.zepto.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

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
        user.setRole("USER-ROLE");
        User save = userRepo.save(user);
        return save;
    }
}
