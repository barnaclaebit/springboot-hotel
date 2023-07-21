package com.barnaclaebit.project.repository;

import com.barnaclaebit.project.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

