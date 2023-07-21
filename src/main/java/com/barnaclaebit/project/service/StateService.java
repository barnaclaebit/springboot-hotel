package com.barnaclaebit.project.service;

import com.barnaclaebit.project.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;
}
