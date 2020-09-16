package com.example.demo.springsecurity;

import com.example.demo.entity.secutiry.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    @Value("${jwt.key}")
    private String secret;

    public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

            jwtUser = new JwtUser();

            jwtUser.setUserName(body.getSubject());
            jwtUser.setId((BigInteger) body.get("id"));
            jwtUser.setRole((String) body.get("role"));
        } catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}
