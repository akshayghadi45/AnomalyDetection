package com.example.anomalydetection.services;

import com.example.anomalydetection.dtos.JwtResponse;
import com.example.anomalydetection.dtos.UserLoginDto;

public interface AuthService {
    public JwtResponse authenticateUser(UserLoginDto userLoginDto);

}
