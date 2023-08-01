package com.barnaclaebit.project.repository;

import com.barnaclaebit.project.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reserve, Long> {
}
