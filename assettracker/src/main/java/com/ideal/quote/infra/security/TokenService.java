package com.ideal.quote.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.ideal.quote.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public
class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public
    String generateToken ( User user ) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("Quote API")
                    .withSubject(user.getLogin())
                    .withExpiresAt(expirationTime())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("error", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("Quote API ")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException(" Invalid Token JWT!");
        }
    }

    private
    Instant expirationTime() {
        return LocalDateTime.now().plusHours(2).toInstant( ZoneOffset.of("-03:00"));
    }
}
