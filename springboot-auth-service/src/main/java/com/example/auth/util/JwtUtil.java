package com.example.auth.util;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {

private String SECRET="secret";

public String generateToken(String username){
return Jwts.builder()
.setSubject(username)
.setIssuedAt(new Date())
.setExpiration(new Date(System.currentTimeMillis()+3600000))
.signWith(SignatureAlgorithm.HS256,SECRET)
.compact();
}
}