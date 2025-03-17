package com.hsptsdb.hospitalproject.hspt.dto;

import com.hsptsdb.hospitalproject.hspt.model.DailySchedule;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DailyScheduleDTO {

    private Long id;
    private LocalTime startTime;
    private LocalTime endTime;
    private DayOfWeek dayOfWeek;
    private Long doctorId;

    // Конструктор для преобразования из сущности
    public DailyScheduleDTO(DailySchedule schedule) {
        this.id = schedule.getId();
        this.startTime = schedule.getStartTime();
        this.endTime = schedule.getEndTime();
        this.dayOfWeek = schedule.getDayOfWeek();
        this.doctorId = schedule.getDoctor().getId();
    }

}
