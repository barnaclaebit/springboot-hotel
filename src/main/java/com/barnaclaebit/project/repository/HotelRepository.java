package com.barnaclaebit.project.repository;

import com.barnaclaebit.project.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
