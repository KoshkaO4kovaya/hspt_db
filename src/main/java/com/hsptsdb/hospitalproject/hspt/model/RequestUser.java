package com.hsptsdb.hospitalproject.hspt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "request_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUser {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_REQUEST_USER"))
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "service_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_REQUEST_SERVICE"))
    private Service service;



    @Column(name = "rent_date", nullable = false)
    private LocalDateTime rentDate;
}
