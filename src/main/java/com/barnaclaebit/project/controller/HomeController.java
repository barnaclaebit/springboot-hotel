package com.barnaclaebit.project.controller;

import com.barnaclaebit.project.entity.Continent;
import com.barnaclaebit.project.entity.Currency;
import com.barnaclaebit.project.service.ContinentService;
import com.barnaclaebit.project.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {




    //test endpoints
    @Autowired
    private ContinentService continentService;
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/info")
    public String getHomePageInfo() {
        return "algumas infos";
    }


}
