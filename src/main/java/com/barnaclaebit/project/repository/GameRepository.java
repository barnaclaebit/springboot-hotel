package com.barnaclaebit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barnaclaebit.project.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
