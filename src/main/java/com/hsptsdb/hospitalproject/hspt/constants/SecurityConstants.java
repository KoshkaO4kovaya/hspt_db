package com.hsptsdb.hospitalproject.hspt.constants;

import java.util.List;

public interface SecurityConstants {
    List<String> RESOURCES_WHITE_LIST = List.of(
            "/images/**",
            "/webjars/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-resources/**", // Добавь эту строку
            "/v2/api-docs/**",
            "/swagger-ui.html",
            "/swagger-ui/index.html"
    );
    List<String> USERS_WHITE_LIST = List.of(
            "/api/auth/registration",
            "/api/auth/login",
            "/api/auth/activate/*",
            "/api/auth/restore-password",
            "/api/auth/change-password"
    );
    List<String> DOCTORS_PERMISSIONS_LIST = List.of(
    );

}