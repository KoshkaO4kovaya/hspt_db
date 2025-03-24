package com.hsptsdb.hospitalproject.hspt.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role extends GenericModel{

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
}
