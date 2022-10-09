package com.se.springboot_activemq.controller;

import com.se.springboot_activemq.model.User;
import com.se.springboot_activemq.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final AuthenticationManager authenticationManager;
    
    private final JwtProvider jwtProvider;
    
    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }
    
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestParam String username, @RequestParam String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            String role = authentication.getAuthorities().toString();
            String token = jwtProvider.createToken(username, role);
            Map<String, String> response = Map.of("username", username, "role", role, "token", token);
            return ResponseEntity.ok().body(response);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            throw new AuthenticationException("Invalid username or password") {
            };
        }
        
    }
}
