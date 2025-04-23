package com.timokloks.parkplaats.models;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Username is required")
    private String username;

    @Email(message = "Email should be valid")
    @NotBlank
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "City is required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "City must contain only letters and spaces")
    private String city;

    @NotBlank(message = "Country is required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Country must contain only letters and spaces")
    private String country;

    @NotBlank(message = "Profile picture url is required")
    private String profilePictureUrl;

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
