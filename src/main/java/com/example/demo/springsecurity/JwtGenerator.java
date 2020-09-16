package com.example.demo.springsecurity;

import com.example.demo.entity.secutiry.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    @Value("${jwt.key}")
    private String jwtKey;

    public String generate(JwtUser jwtUser) {

        Claims claims = Jwts.claims().setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, jwtKey).compact();
    }
}
