package com.barnaclaebit.project.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.barnaclaebit.project.entity.User;
import com.barnaclaebit.project.entity.dto.AuthDTO;
import com.barnaclaebit.project.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService  {

    @Autowired
    private UserRepository userRepository;
    private static final String SECRET_SEED = "barnaclaebit"; //"seed" to generate a hash token

    public ResponseEntity<String> generateTokenBearer(@NonNull User user) {
        try {
            String token = JWT.create().withIssuer("auth-api").withSubject(user.getUsername()).withExpiresAt(generateExpirationDate()).sign(Algorithm.HMAC256(SECRET_SEED));

            return ResponseEntity.ok(new AuthDTO(token, "Bearer").getJson());

        } catch (RuntimeException ex) {
            return new ResponseEntity<String>("Error on generate the token. Contact the support team.", HttpStatus.UNAUTHORIZED);
        }
    }

    public String validateToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(SECRET_SEED)).withIssuer("auth-api").build().verify(token).getSubject(); //send the user if he is logged or not expired
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));//generate a time to expire the token
    }
}
