package com.barnaclaebit.project.service;

import com.barnaclaebit.project.entity.Continent;
import com.barnaclaebit.project.entity.Reserve;
import com.barnaclaebit.project.repository.ReserveRepository;
import com.barnaclaebit.project.repository.ReserveRespositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService {

    @Autowired
    private ReserveRespositoryImpl reserveRespository;

    public List<Reserve> getReserveByCity() {
        return null;
    }

    public List<Reserve> getReserveByContinent(Continent continent) {
        return reserveRespository.getReserveByContinent(continent);
    }

    public List<Reserve> getReserveByCountry() {
        return null;
    }

    public List<Reserve> getReserveByState() {
        return null;
    }
}
