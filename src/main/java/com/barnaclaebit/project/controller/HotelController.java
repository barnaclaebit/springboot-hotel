package com.barnaclaebit.project.controller;

import com.barnaclaebit.project.entity.dto.HotelDTO;
import com.barnaclaebit.project.entity.dto.ReturnResponse;
import com.barnaclaebit.project.entity.vo.HotelVO;
import com.barnaclaebit.project.service.HotelService;
import com.barnaclaebit.project.utils.Utils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @PostMapping()
    public HotelDTO save(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @RequestBody @Valid HotelVO hotelVO) throws IOException {

        try {
            return hotelService.save(hotelVO).modelToDTO();
        } catch (Exception ex) {

            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            response.getWriter().write(Utils.getJson(new ReturnResponse(HttpStatus.BAD_REQUEST, "Error: " + ex.getMessage())));
            return null;
        }
    }

    @DeleteMapping()
    public void delete(@NonNull HttpServletRequest request, @NonNull HttpServletResponse
            response, @RequestBody @Valid HotelVO hotelVO) throws IOException {

        try {
            hotelService.delete(hotelVO);
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            response.getWriter().write(Utils.getJson(new ReturnResponse(HttpStatus.BAD_REQUEST, "Error: " + ex.getMessage())));
        }
    }

    public HotelDTO get(@NonNull HttpServletRequest request, @NonNull HttpServletResponse
            response, @RequestBody @Valid HotelVO hotelVO) throws IOException {
        try {
            return hotelService.get(hotelVO).modelToDTO();
        } catch (Exception ex) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            response.getWriter().write(Utils.getJson(new ReturnResponse(HttpStatus.BAD_REQUEST, "Error: " + ex.getMessage())));
            return null;
        }
    }
}