package com.example.clinicmangmentsystem;

import java.io.Serializable;

public class LoginResponse implements Serializable {

private String user_id;
    private String email;

   private String password;

    public String getEmail() {
        return email;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
