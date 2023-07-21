package com.barnaclaebit.project.service;

import com.barnaclaebit.project.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;
}
