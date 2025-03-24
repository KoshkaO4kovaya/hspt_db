package com.hsptsdb.hospitalproject.hspt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.hsptsdb.hospitalproject.hspt.constants.SecurityConstants.*;
import static com.hsptsdb.hospitalproject.hspt.constants.UserRoleConstants.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public WebSecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(RESOURCES_WHITE_LIST.toArray(String[]::new)).permitAll()
                        .requestMatchers(USERS_WHITE_LIST.toArray(String[]::new)).permitAll()
                        .requestMatchers(DOCTORS_PERMISSIONS_LIST.toArray(String[]::new)).hasAnyRole(ADMIN, DOCTOR)
                        .anyRequest().authenticated() // Все прочие запросы доступны аутентифицированным пользователям
                )
                // Настраиваем вход в систему
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                );

        return httpSecurity.build();
    }


}