package com.barnaclaebit.project.controller;

import com.barnaclaebit.project.entity.dto.ReturnResponse;
import com.barnaclaebit.project.service.CountryService;
import com.barnaclaebit.project.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/city")
public class CountryController {

    @Autowired
    private CountryService service;


    @PostMapping()
    public void save(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response) throws IOException {
        try {

        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            response.getWriter().write(Utils.getJson(new ReturnResponse(HttpStatus.BAD_REQUEST, "Error: " + ex.getMessage())));
        }

    }
}
