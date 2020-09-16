package com.example.demo.entity.secutiry;

import java.math.BigInteger;

public class UserResponse {
    private BigInteger id;
    private String role;
    private String userName;
    private String token;

    public UserResponse() {

    }

    public UserResponse(BigInteger id, String role, String userName, String token) {
        this.id = id;
        this.role = role;
        this.userName = userName;
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserResponse{" + "id='" + id + '\'' + ", role='" + role + '\'' + ", userName='" + userName + '\''
                + ", token='" + token + '\'' + '}';
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
