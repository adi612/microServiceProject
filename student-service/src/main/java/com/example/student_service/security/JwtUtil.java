package com.example.student_service.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "secretkey123secretkey123secretkey123";
    private static final Key SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build()
            .parseClaimsJws(token).getBody().getSubject();
    }

    public static String extractRole(String token) {
        return (String) Jwts.parserBuilder().setSigningKey(SECRET_KEY).build()
            .parseClaimsJws(token).getBody().get("role");
    }

    public static boolean isTokenValid(String token) {
        Date expiration = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build()
            .parseClaimsJws(token).getBody().getExpiration();
        return expiration.after(new Date());
    }
}
