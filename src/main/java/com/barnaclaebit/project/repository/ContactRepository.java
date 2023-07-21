package com.barnaclaebit.project.repository;

import com.barnaclaebit.project.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
