package com.example.anomalydetection.controllers;

import com.example.anomalydetection.dtos.JwtResponse;
import com.example.anomalydetection.dtos.UserLoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/user")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserLoginDto logindto){
        // TODO: authenticate and generate JWT token

        return ResponseEntity.ok(new JwtResponse());
    }

    @PostMapping("logout")
    public ResponseEntity<Void> logout(){

        //TODO: invalidate token if required
        return ResponseEntity.ok().build();
    }
}
