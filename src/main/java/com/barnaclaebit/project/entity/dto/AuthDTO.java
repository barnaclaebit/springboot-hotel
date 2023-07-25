package com.barnaclaebit.project.entity.dto;

public record AuthDTO(String token, String type) {

    public String getJson(){
        return "{" + "token:" + token + "," + "type: " + type + "}";
    }
}
