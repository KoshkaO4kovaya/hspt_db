package com.hsptsdb.hospitalproject.hspt.dto;

import com.hsptsdb.hospitalproject.hspt.model.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO
        extends GenericDTO{
    private String name;
    private String password;
    private String email;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String address;
    private RoleDTO role;
    private Gender gender;
    private String changePasswordToken;
    private List<Long> userRequest;
    private boolean isDeleted;
}
