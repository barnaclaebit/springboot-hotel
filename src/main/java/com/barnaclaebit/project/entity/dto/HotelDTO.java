package com.barnaclaebit.project.entity.dto;

import com.barnaclaebit.project.entity.Address;
import com.barnaclaebit.project.entity.Reserve;

import java.util.Date;
import java.util.List;

public record HotelDTO(String name, String otherInformation, Address address, Date since, boolean isActive, List<Reserve> reservation) {
}
