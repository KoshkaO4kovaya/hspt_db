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

    private LocalDate birthDate;

    @NotBlank(message = "Имя не может быть пустым")
    private String firstName;

    @NotBlank(message = "Фамилия не может быть пустой")
    private String lastName;

    private String middleName;

    @Pattern(regexp = "\\d{10}", message = "Неверный формат телефона")
    private String phone;

    @NotBlank(message = "Адрес не может быть пустым")
    private String address;

    private RoleDTO role;
    private Gender gender;

    private boolean isDeleted;
}
