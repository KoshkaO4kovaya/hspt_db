package com.hsptsdb.hospitalproject.hspt.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DoctorDTO
        extends GenericDTO{
        private String password;
        private String email;
        private LocalDate birthDate;
        private String firstName;
        private String lastName;
        private String middleName;
        private String phone;
        private String address;
        private RoleDTO role;
        private String profession;
        private String experienceYears;
        private boolean isDeleted;
}
