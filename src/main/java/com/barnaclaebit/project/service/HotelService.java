package com.barnaclaebit.project.service;

import com.barnaclaebit.project.entity.Hotel;
import com.barnaclaebit.project.entity.exception.HotelNotFoundException;
import com.barnaclaebit.project.repository.HotelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    public Optional<Hotel> save(Hotel hotel) throws Exception {

        if (hotel == null) {
            return null;
        }

        return Optional.of(hotelRepository.save(hotel));

    }

    public void delete(Hotel hotel) throws HotelNotFoundException {
        if (hotel == null) {
            throw new HotelNotFoundException();
        }
        hotelRepository.delete(hotel);
    }

    public Optional<Hotel> get(Hotel hotel) throws EntityNotFoundException, IllegalArgumentException{
        if (hotel == null) {
            throw new IllegalArgumentException("Empty parameter is not permitted.");
        }
            return Optional.of(hotelRepository.getReferenceById(hotel.getId()));
    }

    public Optional<List<Hotel>> getByFilter() throws EntityNotFoundException, IllegalArgumentException{
//        if (hotel == null) {
//            throw new IllegalArgumentException("Empty parameter is not permitted.");
//        }
//        return hotelRepository.getByFilter(hotel.getAddress().getDistrict().getCity().getState().getCountry().getId());
        return null;
    }

    public Page<Hotel> getAll(Pageable pageable) {
        return hotelRepository.findAll(pageable);
    }
}
