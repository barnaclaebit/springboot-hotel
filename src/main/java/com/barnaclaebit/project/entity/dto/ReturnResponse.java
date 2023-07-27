package com.barnaclaebit.project.entity.dto;

import org.springframework.http.HttpStatus;

public record ReturnResponse(HttpStatus httpStatus, String message) {
}
