package com.barnaclaebit.project.repository;

import com.barnaclaebit.project.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {


    @Query("SELECT Hotel FROM Hotel WHERE Hotel.Address.District.City.State.Id = :IdState")
    public List<Hotel> getByFilter(@Param("IdState") Long IdState);
}
