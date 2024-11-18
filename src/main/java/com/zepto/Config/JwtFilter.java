package com.zepto.Config;

import com.zepto.entites.User;
import com.zepto.repository.UserRepo;
import com.zepto.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserRepo userRepo;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("Authorization");
//        System.out.println(token);
        if (token!=null){
            String tokenVal = token.substring(8, token.length() - 1);
            System.out.println(tokenVal);
            String username = jwtService.getUsername(tokenVal);
            System.out.println("this is username " + username);
            Optional<User> user = userRepo.findByUsername(username);
            if (user.isPresent()){
                User user1 = user.get();
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(user1, null , Collections.singleton(new SimpleGrantedAuthority(user1.getRole())));
                    authenticationToken.setDetails(new WebAuthenticationDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);


                }
            }
        filterChain.doFilter(request , response);
        }
    }
