package com.barnaclaebit.project.repository;

import com.barnaclaebit.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
