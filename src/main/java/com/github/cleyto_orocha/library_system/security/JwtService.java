package com.github.cleyto_orocha.library_system.security;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.github.cleyto_orocha.library_system.entities.Users;

@Service
public class JwtService {

    @Value("${jwt.key}")
    private String jwtKey;

    @Value("${jwt.expiration}")
    private String jwtExpiration;

    public String generateToken(Users user) {
        try {
            return JWT.create()
                    .withIssuer("library_api")
                    .withSubject(user.getLogin())
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm(this.jwtKey));
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating token", e);
        }

    }

    public String validToken(String token) {
        try {
            return JWT.require(algorithm(this.jwtKey))
                    .withIssuer("library_api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }

    private Algorithm algorithm(String jwtKey) {
        return Algorithm.HMAC512(jwtKey);
    }

    private Date getExpirationDate() {
        Long minutesExpire = Long.valueOf(this.jwtExpiration);
        LocalDateTime plusMinutes = LocalDateTime.now().plusMinutes(minutesExpire);
        return Date.from(plusMinutes.atZone(ZoneId.systemDefault()).toInstant());
    }
}
