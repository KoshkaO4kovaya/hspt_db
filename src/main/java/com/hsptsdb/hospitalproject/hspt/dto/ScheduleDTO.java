package com.hsptsdb.hospitalproject.hspt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {

    private Long id; // Идентификатор расписания
    private Long doctorId; // Идентификатор врача
    private String dayOfWeek; // День недели (например, "Понедельник")
    private LocalDateTime startTime; // Время начала
    private LocalDateTime endTime; // Время окончания

}
