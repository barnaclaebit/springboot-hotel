package com.barnaclaebit.project.service;

import com.barnaclaebit.project.entity.User;
import com.barnaclaebit.project.entity.exception.UserFoundException;
import com.barnaclaebit.project.entity.exception.UserNotFoundException;
import com.barnaclaebit.project.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User save(User user) throws UserFoundException, IllegalArgumentException, OptimisticLockingFailureException {

		if (userRepository.findByUsername(user.getUsername()) != null)
			throw new UserFoundException();

		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

		return userRepository.save(user);

	}

	public Optional<User> findById(Long id) throws UserNotFoundException {

		Optional<User> user = userRepository.findById(id);

		if (user != null)
			return user;

		throw new UserNotFoundException();
	}

}
