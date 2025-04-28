package com.timokloks.parkplaats.services;

import com.timokloks.parkplaats.models.UserModel;
import com.timokloks.parkplaats.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String registerUser(UserModel user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            return "Email already in use.";
        }
        if(userRepository.existsByUsername(user.getUsername())) {
            return "Username already taken.";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return "User registered successfully";
    }
}
