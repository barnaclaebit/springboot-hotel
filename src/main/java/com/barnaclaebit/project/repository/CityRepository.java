package com.barnaclaebit.project.repository;

import com.barnaclaebit.project.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
