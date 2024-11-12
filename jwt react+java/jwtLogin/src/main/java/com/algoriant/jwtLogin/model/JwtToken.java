package com.algoriant.jwtLogin.model;

import javax.persistence.Entity;

public class JwtToken {

    private String username;
    private String password;

    public JwtToken(){

    }

    public JwtToken( String username, String password){

        this.username = username;
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}