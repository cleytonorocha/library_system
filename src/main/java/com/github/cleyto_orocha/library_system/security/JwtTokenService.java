package com.github.cleyto_orocha.library_system.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenService {
    @Value("$(jwt.key)")
    private String jwtKey;

    @Value("$(jwt.expiration)")
    private Long jwtExpiration;

    public String generateToken(User user, List<String> roles) {
        long minutesExpire = Long.valueOf(this.jwtExpiration);
        LocalDateTime plusMinutes = LocalDateTime.now().plusMinutes(minutesExpire);
        Instant toInstant = plusMinutes.atZone(ZoneId.systemDefault()).toInstant();
        Date from = Date.from(toInstant);

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(from)
                .signWith(SignatureAlgorithm.HS512, jwtKey)
                .compact();
    }

    public Boolean validToken(String token) {
        Claims claims = getClaims(token);
        Date expiration = claims.getExpiration();
        LocalDateTime localDateTime = expiration.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return LocalDateTime.now().isBefore(localDateTime);

    }

    private Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts.parser()
                .setSigningKey(jwtKey)
                .parseClaimsJwt(token)
                .getBody();
    }

     public String getUserLogin(String token) throws ExpiredJwtException {
        return (String) getClaims(token).getSubject();
    }

}
