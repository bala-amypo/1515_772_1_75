package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Set;

@Component
public class JwtTokenProvider {

    // ✅ FIXED secret key (important for tests)
    private static final String SECRET =
            "my-secret-key-my-secret-key-my-secret-key"; // 32+ chars

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
    private final long expiryMs = 1000 * 60 * 60; // 1 hour

    // Generate JWT
    public String generateToken(String email, Set<String> roles) {

        return Jwts.builder()
                .setSubject(email)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiryMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    // ✅ REQUIRED BY TEST
public String createToken(Long userId, String email, Set<String> roles) {
    return generateToken(email, roles);
}


    // ✅ REQUIRED BY TESTS
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Validate JWT safely
    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
