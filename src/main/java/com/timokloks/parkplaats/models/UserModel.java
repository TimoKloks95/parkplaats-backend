package com.timokloks.parkplaats.models;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "username")
        }
)
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Username is required")
    private String username;

    @Email(message = "Email should be valid") @Column(unique = true)
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

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
