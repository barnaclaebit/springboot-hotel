package com.barnaclaebit.project.controller;

import com.barnaclaebit.project.entity.dto.UserDTO;

import com.barnaclaebit.project.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping()
	public ResponseEntity<?> get(@RequestBody @Valid UserDTO userDTO) {

		try {

			return ResponseEntity.ok(userService.findById(userDTO.id()));
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.notFound().build();
		}

	}

}
