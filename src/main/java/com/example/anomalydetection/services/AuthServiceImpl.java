package com.example.anomalydetection.services;

import com.example.anomalydetection.dtos.JwtResponse;
import com.example.anomalydetection.dtos.UserLoginDto;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public JwtResponse authenticateUser(UserLoginDto userLoginDto) {
        //yet to implement
        return null;
    }


    /*

    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public JwtResponse authenticateUser(UserLoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
        );

        String token = jwtTokenProvider.generateToken(authentication);

        User user = userRepository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        var roles = user.getRole() != null ? List.of(user.getRole()) : List.of();

        return new JwtResponse(token, user.getUsername(), roles);
    }

    // Additional methods like user registration, password encoding can be added later
}

     */
}
