package com.barnaclaebit.project.entity.exception;

public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException() {
        super("Hotel not found.");
    }


    public static String HOTEL_NOT_FOUND = "Hotel not found.";
}
