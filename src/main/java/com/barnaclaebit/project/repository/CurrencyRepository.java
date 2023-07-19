package com.barnaclaebit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barnaclaebit.project.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    
}
