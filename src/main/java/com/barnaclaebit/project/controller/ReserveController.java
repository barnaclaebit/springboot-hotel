package com.barnaclaebit.project.controller;

import com.barnaclaebit.project.entity.Reserve;
import com.barnaclaebit.project.entity.vo.*;
import com.barnaclaebit.project.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @GetMapping("/state")
    public void getReserveByState(StateVO stateVO){

    }

    @GetMapping("/country")
    public void getReserveByCountry(CountryVO countryVO){

    }

    @GetMapping("/city")
    public void getReserveByCity(CityVO cityVO){

    }

    @GetMapping("/continent")
    public List<Reserve> getReserveByContinent(ContinentVO continentVO){
        return reserveService.getReserveByContinent(continentVO);
    }

}
