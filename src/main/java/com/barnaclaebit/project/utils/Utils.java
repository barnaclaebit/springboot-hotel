package com.barnaclaebit.project.utils;

import com.google.gson.Gson;

public class Utils {


    public static String getJson(Object object){
        return new Gson().toJson(object);
    }
}
