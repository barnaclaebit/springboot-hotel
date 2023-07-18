package com.barnaclaebit.project.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class City {

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private State state;
    
}
