package com.barnaclaebit.project.repository;

import com.barnaclaebit.project.entity.Hotel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
	Page<Hotel> findAll(Pageable pageable);


//    @Query("SELECT Hotel FROM Hotel WHERE Hotel.Address.District.City.State.Id = :IdState")
//    public List<Hotel> getByFilter(@Param("IdState") Long IdState);
}
