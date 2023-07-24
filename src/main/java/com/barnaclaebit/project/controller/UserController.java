package com.barnaclaebit.project.controller;

import com.barnaclaebit.project.entity.User;
import com.barnaclaebit.project.entity.dto.AuthenticationDTO;
import com.barnaclaebit.project.entity.dto.UserDTO;
import com.barnaclaebit.project.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity insert(@RequestBody @Valid UserDTO userDTO) {
        if (userRepository.findByUsername(userDTO.username()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(userDTO.password());
        User user = new User(userDTO.username(), encryptedPassword, userDTO.role());
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }


}
