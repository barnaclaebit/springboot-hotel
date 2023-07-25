package com.barnaclaebit.project.service;

import com.barnaclaebit.project.entity.User;
import com.barnaclaebit.project.entity.dto.AuthDTO;
import com.barnaclaebit.project.entity.dto.AuthenticationDTO;
import com.barnaclaebit.project.entity.dto.UserDTO;
import com.barnaclaebit.project.repository.UserRepository;
import com.barnaclaebit.project.security.service.TokenService;
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

import java.util.Map;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override //auth the user by username in db using the UserDetails
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username);
    }

}
