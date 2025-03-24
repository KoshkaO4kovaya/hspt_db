package com.hsptsdb.hospitalproject.hspt.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(name = "uniqueEmail", columnNames = "email"),
                @UniqueConstraint(name = "uniqueLogin", columnNames = "login")
        }) 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "users_seq", allocationSize = 1)
public class User extends GenericModel{

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name ="surname", nullable = false)
    private String firstName;

    @Column(name = "patronym", nullable = false)
    private String lastName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "snils", nullable = false)
    private String snils;

    @Column(name = "series_passport")
    private String series_passport;

    @Column(name = "number_passport")
    private String number_passport;

    @Column(name = "data_passport")
    private LocalDate data_passport;

    @Column(name = "gender", nullable = false)
    @Enumerated
    private Gender gender;

    @ManyToOne (cascade = CascadeType.MERGE) // много пользователей могут иметь одну роль
    @JoinColumn(name = "role_id", nullable = false,
            foreignKey = @ForeignKey(name = "USERS_ROLES"))
    private Role role;
}
