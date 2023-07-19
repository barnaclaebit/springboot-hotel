package com.barnaclaebit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barnaclaebit.project.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
