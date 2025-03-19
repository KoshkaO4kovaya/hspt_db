package com.hsptsdb.hospitalproject.hspt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "service_sequence", allocationSize = 1)
public class Service extends GenericModel {

    @Column(name = "title", nullable = false)
    private String serviceTitle;

    @Column(name = "category", nullable = false)
    @Enumerated
    private Category category;

    @Column(name = "description")
    private String description;

    @JsonIgnore // Избавляет от ошибки Stack Overflow, JSON зацикливается: У книги есть автор, у автора есть книга, у книги есть автор...
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "services_doctor",
            joinColumns = @JoinColumn(name = "service_id"), foreignKey = @ForeignKey(name = "FK_BOOKS_AUTHORS"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id"), inverseForeignKey = @ForeignKey(name = "FK_AUTHORS_BOOKS"))
    List<Doctor> doctors;
}