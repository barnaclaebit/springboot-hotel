package com.barnaclaebit.project.controller;

import com.barnaclaebit.project.entity.dto.HotelDTO;
import com.barnaclaebit.project.entity.dto.ReturnResponse;
import com.barnaclaebit.project.entity.exception.HotelNotFoundException;
import com.barnaclaebit.project.entity.vo.HotelVO;
import com.barnaclaebit.project.service.HotelService;
import com.barnaclaebit.project.utils.Utils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping()
    public ResponseEntity<?> get(@NonNull HttpServletRequest request, @NonNull HttpServletResponse
            response, @RequestBody HotelVO hotelVO) throws IOException {
        try {
            HotelDTO hotelDTO = hotelService.get(hotelVO).modelToDTO();

            if(hotelDTO != null)
                return ResponseEntity.ok(hotelService.get(hotelVO));
            else
                return (ResponseEntity<?>) ResponseEntity.notFound();

        } catch (IllegalArgumentException ex) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            response.getWriter().write(Utils.getJson(new ReturnResponse(HttpStatus.BAD_REQUEST, "Error: " + ex.getMessage())));
            return null;
        }catch (EntityNotFoundException ex){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            response.getWriter().write(Utils.getJson(new ReturnResponse(HttpStatus.BAD_REQUEST, "Error: " + HotelNotFoundException.HOTEL_NOT_FOUND)));
            return null;
        }
    }

//    @GetMapping()
//    public ResponseEntity<?> getList(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @RequestBody HotelVO hotelVO) throws IOException{
//       return null;
//    }

}