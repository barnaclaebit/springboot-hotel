package com.barnaclaebit.project.service;

import com.barnaclaebit.project.entity.Reserve;
import com.barnaclaebit.project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reserve> getReserveByCity(){
        return null;
    }

    public List<Reserve> getReserveByContinent(){
        return null;
    }

    public List<Reserve> getReserveByCountry(){
        return null;
    }

    public List<Reserve> getReserveByRegion(){
        return null;
    }

    public List<Reserve> getReserveByState(){
        return null;
    }
}
