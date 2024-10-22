package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "USERS")
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNo;

    // Override toString to exclude sensitive information
    @Override
    public String toString() {
        return "User{id='" + id + "', firstName='" + firstName + "', lastName='" + lastName + "', email='" + email + "'}";
    }
}
