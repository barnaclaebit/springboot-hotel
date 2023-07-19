package com.barnaclaebit.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barnaclaebit.project.entity.Continent;
import com.barnaclaebit.project.entity.Currency;
import com.barnaclaebit.project.service.ContinentService;
import com.barnaclaebit.project.service.CurrencyService;

@RestController
@RequestMapping("/")
public class HomeController {



    //test endpoints
    @Autowired
    private ContinentService continentService;
    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public String getHomePageInfos(){
        return "algumas infos";
    }

    @GetMapping("/currency")
    public List<Currency> getCurrency(){
        return currencyService.getCurrency();
    }

    @GetMapping("/continent")
    public List<Continent> getContinents(){
        return continentService.getContinent();
    }



}
