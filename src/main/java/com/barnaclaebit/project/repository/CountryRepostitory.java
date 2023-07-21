package com.barnaclaebit.project.repository;

import com.barnaclaebit.project.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepostitory extends JpaRepository<Country, Long> {
}
