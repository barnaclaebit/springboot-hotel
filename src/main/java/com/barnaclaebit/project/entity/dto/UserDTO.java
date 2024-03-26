package com.barnaclaebit.project.entity.dto;

import com.barnaclaebit.project.entity.Role;
import com.barnaclaebit.project.entity.User;

public record UserDTO(Long id, String username, String password, Role role) {

	public User dtoToEntity() {
		return new User(this.id, this.username, this.password, this.role);
	}
}
