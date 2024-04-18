package com.barnaclaebit.project.controller;

import com.barnaclaebit.project.entity.Hotel;
import com.barnaclaebit.project.entity.dto.HotelDTO;
import com.barnaclaebit.project.entity.dto.PaginationDTO;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping()
    public HotelDTO save(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @RequestBody @Valid HotelVO hotelVO) throws IOException {

        try {
            return hotelService.save(hotelVO).get().modelToDTO();
        } catch (Exception ex) {

            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            response.getWriter().write(Utils.getJson(new ReturnResponse(HttpStatus.BAD_REQUEST, "Error: " + ex.getMessage())));
            return null;
        }
    }

	@DeleteMapping()
	public void delete(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
			@RequestBody @Valid HotelVO hotelVO) throws IOException {

		try {
			hotelService.delete(hotelVO);
		} catch (Exception ex) {

			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setContentType("application/json");
			response.getWriter()
					.write(Utils.getJson(new ReturnResponse(HttpStatus.BAD_REQUEST, "Error: " + ex.getMessage())));
		}
	}

	@GetMapping()
	public ResponseEntity<?> get(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
			@RequestBody HotelVO hotelVO) throws IOException {
		try {

			Optional<Hotel> hotel = hotelService.get(hotelVO);

			if (hotel.isPresent())
				return ResponseEntity.ok(hotel);
			else
				return (ResponseEntity<?>) ResponseEntity.notFound();

		} catch (IllegalArgumentException ex) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setContentType("application/json");
			response.getWriter()
					.write(Utils.getJson(new ReturnResponse(HttpStatus.BAD_REQUEST, "Error: " + ex.getMessage())));
			return null;
		} catch (EntityNotFoundException ex) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setContentType("application/json");
			response.getWriter().write(Utils.getJson(
					new ReturnResponse(HttpStatus.BAD_REQUEST, "Error: " + HotelNotFoundException.HOTEL_NOT_FOUND)));
			return null;
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll(HttpServletRequest request, HttpServletResponse response,
			@RequestBody PaginationDTO paginationDTO) throws IOException {
				
		try {
			
			return ResponseEntity
					.ok(hotelService.getAll(PageRequest.of(paginationDTO.page(), paginationDTO.items())).getContent());
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setContentType("application/json");
			response.getWriter()
					.write(Utils.getJson(new ReturnResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error: " + e.getMessage())));
		}
		return null;

	}

}