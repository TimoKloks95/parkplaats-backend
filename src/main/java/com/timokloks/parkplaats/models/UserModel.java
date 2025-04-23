package com.timokloks.parkplaats.models;

import jakarta.persistence.*;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String email;
    private String password;

    private String city;
    private String country;

    @Lob
    private byte[] profilePicture;


}
