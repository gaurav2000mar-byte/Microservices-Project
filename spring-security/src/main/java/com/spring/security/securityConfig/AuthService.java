package com.spring.security.securityConfig;

import com.spring.security.dto.LoginRequest;
import com.spring.security.dto.RegisterRequest;
import com.spring.security.model.AppUser;
import com.spring.security.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    // Register new user
    public String register(RegisterRequest request) {

        AppUser user = AppUser.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(request.getRoles())
                .build();

        userRepo.save(user);

        return "User Registered Successfully!";
    }

    // Login and generate token
    public String login(LoginRequest request) {

        // check username & password
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()
                )
        );

        // generate JWT
        return jwtUtil.generateToken(request.getUsername());
    }
}
