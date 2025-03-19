package com.hsptsdb.hospitalproject.hspt.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = "service_schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceSchedule {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(name = "day_of_week", nullable = false)
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Column(name = "duration", nullable = false)
    private Integer duration; // Продолжительность приема в минутах

    @Column(name = "break_time", nullable = false)
    private Integer breakTime; // Время перерыва между приемами в минутах

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(name = "is_booked", nullable = false)
    private Boolean isBooked; // Флаг, показывающий, забронировано ли время
}
