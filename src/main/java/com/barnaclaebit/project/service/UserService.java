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

		if ((userRepository.findByUsername(user.getUsername()) != null) && (user.getId() == 0))
			throw new UserFoundException();

		if (user.getId() == 0)
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

		return userRepository.save(user);

	}

	public Optional<User> findById(Long id) throws UserNotFoundException {

		Optional<User> user = userRepository.findById(id);

		if (!user.isEmpty())
			return user;

		throw new UserNotFoundException();
	}

	public void delete(Long id) throws UserNotFoundException {

		if (userRepository.findById(id).isEmpty())
			throw new UserNotFoundException();

		userRepository.deleteById(id);

	}

}
