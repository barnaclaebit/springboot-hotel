package com.barnaclaebit.project.utils;

import java.lang.reflect.Array;
import java.util.List;

import static com.barnaclaebit.project.utils.Constants.*;

public class EndPoints {

    public static final List<String> PUBLIC_GET = List.of(
             HOME_INFO_GET
    );
    public static final List<String> PUBLIC_POST = List.of(
            AUTH_LOGIN_POST
    );
    public static final List<String> PUBLIC_PUT = List.of(

    );
    public static final List<String> PUBLIC_DELETE = List.of(

    );
    public static final List<String> PRIVATE_GET = List.of(
              RESERVE_REGION_GET
            , RESERVE_CONTINENT_GET
            , RESERVE_CITY_GET
            , RESERVE_COUNTRY_GET
            , RESERVE_STATE_GET
    );

    public static final List<String> PRIVATE_POST = List.of(
             USER_REGISTER_POST
    );

    public static final List<String> PRIVATE_PUT = List.of(

    );

    public static final List<String> PRIVATE_DELETE = List.of(

    );
}
