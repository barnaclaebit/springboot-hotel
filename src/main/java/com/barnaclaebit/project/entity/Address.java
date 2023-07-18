package com.barnaclaebit.project.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Address {

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private District disctrict;
    private String street;
    private int number;
    
}
