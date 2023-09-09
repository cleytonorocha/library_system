package com.github.cleyto_orocha.library_system.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.cleyto_orocha.library_system.entities.Users;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

    @Value("${jwt.expiration}")
    private String jwtExpiration;

    @Value("${jwt.key}")
    private String jwtKey;

    public String generateToken(Users user) {
        long minutesExpire = Long.valueOf(this.jwtExpiration);
        LocalDateTime plusMinutes = LocalDateTime.now().plusMinutes(minutesExpire);
        Instant toInstant = plusMinutes.atZone(ZoneId.systemDefault()).toInstant();
        Date from = Date.from(toInstant);

        return Jwts.builder()

                .setSubject(user.getLogin())
                .setExpiration(from)
                .signWith(SignatureAlgorithm.HS512, jwtKey)
                .compact();
    }

    public boolean validToken(String token) {
        try {
            Claims claims = getClaims(token);
            Date expiration = claims.getExpiration();
            LocalDateTime localDateTime = expiration.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return LocalDateTime.now().isBefore(localDateTime);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parser()
                .setSigningKey(jwtKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getLoginByUser(String token) throws ExpiredJwtException {
        return getClaims(token).getSubject();
    }

}
