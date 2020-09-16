/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rajanikant
 */

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    final static Logger logger = LoggerFactory.getLogger(UserController.class);

    
    @GetMapping
    public String getUser(Authentication authentication){
        return authentication.getName();
    }

    @GetMapping(value = "/role")
    public Collection<? extends GrantedAuthority> getUserRole(Authentication authentication){
        return authentication.getAuthorities();
    }
    
    
}
