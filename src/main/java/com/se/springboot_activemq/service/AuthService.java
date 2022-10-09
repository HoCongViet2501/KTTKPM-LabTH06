package com.se.springboot_activemq.service;

import com.se.springboot_activemq.model.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(String username, String password) throws Exception;
}
