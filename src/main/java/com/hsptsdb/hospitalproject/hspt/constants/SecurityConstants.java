package com.hsptsdb.hospitalproject.hspt.constants;

import java.util.List;

public interface SecurityConstants {
    List<String> RESOURCES_WHITE_LIST = List.of(
            "/resources/",
            "/swagger-ui/",
            "/webjars/bootstrap/5.3.3/",
            "/v3/api-docs/**");



    List<String> DOCTORS_PERMISSIONS_LIST = List.of(
            "/doctors/add",
            "doctors/update",
            "doctors/delete"
    );

    List<String> USERS_WHITE_LIST = List.of(
            "/login",
            "/users/registration",
            "/users/remember-password",
            "/users/profile/**"
    );



}