package com.barnaclaebit.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barnaclaebit.project.entity.Currency;
import com.barnaclaebit.project.repository.CurrencyRepository;

@Service
public class CurrencyService {
    
    @Autowired
    private CurrencyRepository repository;

    public List<Currency> getCurrency(){
        return repository.findAll();
    }
}
