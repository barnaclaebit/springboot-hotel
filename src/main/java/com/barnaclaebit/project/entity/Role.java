package com.barnaclaebit.project.entity;

public enum Role {
    //resp for add roles for users
    ADMIN("admin"),
    USER("user");

    private String role;

    Role(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
