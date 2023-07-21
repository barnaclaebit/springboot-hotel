package com.barnaclaebit.project.service;

import com.barnaclaebit.project.entity.Currency;
import com.barnaclaebit.project.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }
}