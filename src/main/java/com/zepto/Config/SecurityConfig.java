package com.zepto.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
    private final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c->c.disable()).cors(c->c.disable());
        http.addFilterBefore(jwtFilter , AuthorizationFilter.class);
//        http.authorizeHttpRequests(auth->auth.requestMatchers("/api/v1/user/signup" , "/api/v1/user/login")
//                .permitAll()
//                .requestMatchers("/api/grocery/add").hasRole("ADMIN")
//                .anyRequest().authenticated());
        http.authorizeHttpRequests(auth-> auth.anyRequest().permitAll());
        return http.build();
    }
}
