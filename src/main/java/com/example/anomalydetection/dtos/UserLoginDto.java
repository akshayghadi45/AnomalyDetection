package com.example.anomalydetection.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDto {
    private String username;
    private String password;

    //constructors
    public UserLoginDto(){}
    public UserLoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
