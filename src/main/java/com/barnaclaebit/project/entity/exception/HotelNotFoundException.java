package com.barnaclaebit.project.entity.exception;

public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException() {
        super("Hotel not found.");
    }
}
