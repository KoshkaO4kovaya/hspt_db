package com.hsptsdb.hospitalproject.hspt.model;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Table(name = "roles")
@Getter
@Setter

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
}
