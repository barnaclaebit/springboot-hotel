package com.barnaclaebit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barnaclaebit.project.entity.Continent;

public interface ContinentRepository extends JpaRepository<Continent, Long>{
    
}
