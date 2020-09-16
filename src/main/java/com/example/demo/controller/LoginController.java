package com.example.demo.controller;

import com.example.demo.dao.LoginRepository;
import com.example.demo.entity.secutiry.JwtUser;
import com.example.demo.entity.secutiry.LoginRequest;
import com.example.demo.entity.secutiry.UserResponse;
import com.example.demo.springsecurity.JwtGenerator;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private LoginRepository userRepository;
	
		
    @PostMapping(value = "/login")
    public UserResponse generate(@RequestBody final LoginRequest jwtUser) {
        logger.info("User" + jwtUser.toString());
        Optional<JwtUser> user = userRepository.findByUserName(jwtUser.getUserName());

        logger.info("Authenticated User" + user.toString());

        if (user.isPresent()) {
            if (user.get().getUserPassword().equals(jwtUser.getUserPassword())) {
                UserResponse response = new UserResponse(user.get().getId(), user.get().getRole(),
                        user.get().getUserName(), jwtGenerator.generate(user.get()));
                return response;
            } else {
                throw new RuntimeException("User password is invalid!!!");
            }
        } else {
            throw new RuntimeException("User not present!!!");
        }
    }

 
    @PostMapping(value = "/register")
    public ResponseEntity<JwtUser> register(@RequestBody JwtUser user){
        logger.info("user: "+ user);
        JwtUser savedUser = userRepository.save(user);
        return ResponseEntity.ok(user);
    }
}
