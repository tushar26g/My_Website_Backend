package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String mobileNo;

    // Constructors
    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String firstName, String lastName, String email, String password, String gender, String mobileNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.mobileNo = mobileNo;
    }
}
