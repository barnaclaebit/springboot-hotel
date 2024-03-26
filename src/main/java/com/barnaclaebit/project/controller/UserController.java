package com.barnaclaebit.project.controller;

import com.barnaclaebit.project.entity.User;
import com.barnaclaebit.project.entity.dto.AuthenticationDTO;
import com.barnaclaebit.project.entity.dto.UserDTO;
import com.barnaclaebit.project.repository.UserRepository;
import com.barnaclaebit.project.service.UserService;

import jakarta.validation.Valid;

import java.util.Optional;

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
	private UserService userService;

	@PostMapping()
	public ResponseEntity<?> save(@RequestBody @Valid UserDTO userDTO) {
		try {

			return ResponseEntity.ok(userService.save(userDTO.dtoToEntity()));
		} catch (Exception ex) {
			ex.printStackTrace();
			ResponseEntity.internalServerError();
			return null;
		}
	}

	@GetMapping()
	public ResponseEntity<?> get(@RequestBody @Valid UserDTO userDTO) {

		Optional<User> user = userService.findById(userDTO.id());

		if (user == null)
			ResponseEntity.notFound();

		return ResponseEntity.ok(user);

	}

}
