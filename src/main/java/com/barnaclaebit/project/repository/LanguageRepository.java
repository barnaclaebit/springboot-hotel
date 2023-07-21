package com.barnaclaebit.project.repository;

import com.barnaclaebit.project.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
