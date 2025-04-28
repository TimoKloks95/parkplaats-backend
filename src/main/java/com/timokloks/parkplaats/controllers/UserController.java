package com.timokloks.parkplaats.controllers;

import com.timokloks.parkplaats.models.UserModel;
import com.timokloks.parkplaats.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserModel user, BindingResult result) {
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors().toString());
        }

        String registrationResult = userService.registerUser(user);
        if(registrationResult.equals("User registered successfully")) {
            return ResponseEntity.ok(registrationResult);
        }
        else {
            return ResponseEntity.badRequest().body(registrationResult);
        }
    }
}
