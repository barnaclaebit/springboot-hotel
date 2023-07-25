package com.barnaclaebit.project.entity.dto;


import com.google.gson.Gson;

public record AuthDTO(String token, String type) {

    public String getJson() {
        return new Gson().toJson(new AuthDTO(token, type));
    }
}
