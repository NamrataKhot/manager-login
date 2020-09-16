package com.example.demo.entity.secutiry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class JwtUser {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private BigInteger id;
    
    @Column(name = "role")
    private String role;
    
    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    public JwtUser() {
    }

    public JwtUser(BigInteger id, String role, String userName, String userPassword) {
        this.id = id;
        this.role = role;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public BigInteger getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "JwtUser{" + "id='" + id + '\'' + ", role='" + role + '\'' + ", userName='" + userName + '\''
                + ", userPassword='" + userPassword + '\'' + '}';
    }
}
