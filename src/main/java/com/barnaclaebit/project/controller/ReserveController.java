package com.barnaclaebit.project.controller;

import com.barnaclaebit.project.entity.vo.CityVO;
import com.barnaclaebit.project.entity.vo.ContinentVO;
import com.barnaclaebit.project.entity.vo.CountryVO;
import com.barnaclaebit.project.entity.vo.RegionVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserve")
public class ReserveController {


    @GetMapping("/region")
    public void getReserveByRegion(RegionVO regionVO){

    }

    @GetMapping("/country")
    public void getReserveByCountry(CountryVO countryVO){

    }

    @GetMapping("/city")
    public void getReserveByCity(CityVO cityVO){

    }

    @GetMapping("/continent")
    public void getReserveByContinent(ContinentVO continentVO){

    }

}
