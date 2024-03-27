package com.barnaclaebit.project.controller;


import com.barnaclaebit.project.entity.User;
import com.barnaclaebit.project.entity.dto.AuthDTO;
import com.barnaclaebit.project.entity.dto.AuthenticationDTO;
import com.barnaclaebit.project.security.service.TokenService;
import com.barnaclaebit.project.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping()
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {

       try{
           Authentication usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.username(), authenticationDTO.password());

           Authentication authentication = authenticationManager.authenticate(usernamePassword);

           return ResponseEntity.ok(tokenService.generateTokenBearer((User)authentication.getPrincipal()));
       }catch (RuntimeException ex){
           return new ResponseEntity<String>("Username or password is incorrect.", HttpStatus.UNAUTHORIZED);
       }

    }



}
