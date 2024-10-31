package com.example.demo.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

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
    private int coins = 0;  // New field to track coins
    private Date lastLoginDate;  // New field to track last login date

    @Override
    public String toString() {
        return "User{id='" + id + "', firstName='" + firstName + "', lastName='" + lastName + "', email='" + email + "', coins='" + coins + "'}";
    }
}

