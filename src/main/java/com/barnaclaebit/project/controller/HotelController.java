package com.barnaclaebit.project.controller;

import com.barnaclaebit.project.entity.dto.HotelDTO;
import com.barnaclaebit.project.entity.vo.HotelVO;
import com.barnaclaebit.project.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @PostMapping("/save")
    public HotelDTO save(@RequestBody @Valid HotelVO hotelVO){

        try{
            return hotelService.save(hotelVO).modelToDTO();
        }catch (Exception ex){

            return null;
        }

    }

}
