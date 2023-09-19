package com.barnaclaebit.project.service;

import com.barnaclaebit.project.entity.Hotel;
import com.barnaclaebit.project.entity.exception.HotelNotFoundException;
import com.barnaclaebit.project.repository.HotelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    public Hotel save(Hotel hotel) throws Exception {

        if (hotel == null) {
            return null;
        }

        return hotelRepository.save(hotel);

    }

    public void delete(Hotel hotel) throws HotelNotFoundException {
        if (hotel == null) {
            throw new HotelNotFoundException();
        }
        hotelRepository.delete(hotel);
    }

    public Hotel get(Hotel hotel) throws EntityNotFoundException, IllegalArgumentException{
        if (hotel == null) {
            throw new IllegalArgumentException("Empty parameter is not permitted.");
        }
            return hotelRepository.getReferenceById(hotel.getId());
    }

    public List<Hotel> getByFilter() throws EntityNotFoundException, IllegalArgumentException{
//        if (hotel == null) {
//            throw new IllegalArgumentException("Empty parameter is not permitted.");
//        }
//        return hotelRepository.getByFilter(hotel.getAddress().getDistrict().getCity().getState().getCountry().getId());
        return null;
    }

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }
}
