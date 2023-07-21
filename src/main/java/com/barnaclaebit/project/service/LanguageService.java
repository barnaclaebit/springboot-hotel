package com.barnaclaebit.project.service;

import com.barnaclaebit.project.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;
}
