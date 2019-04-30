package com.example.lockeddown;


public class User {

    public String firstName;
    public String lastName;
    public String email;
    public String password;

    //default constructor
    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

}

