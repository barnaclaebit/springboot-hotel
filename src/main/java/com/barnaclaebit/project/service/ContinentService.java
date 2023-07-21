package com.barnaclaebit.project.service;

import com.barnaclaebit.project.entity.Continent;
import com.barnaclaebit.project.repository.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentService {

    @Autowired
    private ContinentRepository continentRepository;

    public List<Continent> getAll(){
        return continentRepository.findAll();
    }

}
