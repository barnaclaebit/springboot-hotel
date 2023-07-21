package com.barnaclaebit.project.repository;

import com.barnaclaebit.project.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
