package com.barnaclaebit.project.entity.dto;

import com.barnaclaebit.project.entity.Role;

public record UserDTO(String username, String password, Role role) {
}
