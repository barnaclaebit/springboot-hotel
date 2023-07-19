package com.barnaclaebit.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barnaclaebit.project.entity.Continent;
import com.barnaclaebit.project.repository.ContinentRepository;

@Service
public class ContinentService {

    @Autowired
    private ContinentRepository repository;

    public List<Continent> getContinent(){
        return repository.findAll();
    }
    
}
