package com.barnaclaebit.project.service;

import com.barnaclaebit.project.repository.CountryRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepostitory repostitory;
}
