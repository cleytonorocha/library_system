package com.github.cleyto_orocha.library_system.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.entities.Users;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

    @Value("{jwt.key}")
    private String jwtKey;

    @Value("${jwt.expiration})")
    private String jwtExpiration;

    public String generateToken(Users user) {
        Long minutesExpire = Long.valueOf(jwtExpiration);
        LocalDateTime plusMinutes = LocalDateTime.now().plusMinutes(minutesExpire);
        Instant toInstant = plusMinutes.atZone(ZoneId.systemDefault()).toInstant();
        Date from = Date.from(toInstant);

        return Jwts.builder()
                .setIssuer("library_api")
                .setSubject(user.getLogin())
                .setExpiration(from)
                .signWith(SignatureAlgorithm.HS512, jwtKey)
                .compact();
    }
}
