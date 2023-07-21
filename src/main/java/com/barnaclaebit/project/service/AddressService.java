package com.barnaclaebit.project.service;

import com.barnaclaebit.project.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository AddressRepository;
}
