package com.barnaclaebit.project.service;

import com.barnaclaebit.project.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;
}
