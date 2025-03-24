package com.hsptsdb.hospitalproject.hspt.dto;

import com.hsptsdb.hospitalproject.hspt.model.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO extends GenericDTO {

    @NotBlank(message = "Имя не может быть пустым")
    private String name;

    @Size(min = 8, message = "Пароль должен содержать не менее 8 символов")
    private String password;

    @Email(message = "Неверный формат email")
    private String email;

    @NotBlank(message = "Фамилия не может быть пустой")
    private String surname;

    @NotBlank(message = "Снилс не можеь быть пустым")
    @Pattern(regexp = "\\d{11}", message = "Снилс должен состоять из 11 цифр")
    private String snils;

    @Pattern(regexp = "\\d{11}", message = "Неверный формат телефона")
    private String phone;

    @NotBlank(message = "Адрес не может быть пустым")
    private String address;

    private String patronym;
    private String series_passport;
    private String number_passport;
    private LocalDate data_passport;
    private LocalDate birthDate;
    private RoleDTO role;
    private Gender gender;

    private boolean isDeleted;
}
