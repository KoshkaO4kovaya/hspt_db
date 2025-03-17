package com.hsptsdb.hospitalproject.hspt.dto;

import com.hsptsdb.hospitalproject.hspt.model.WeeklySchedule;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeeklyScheduleDTO {

    private Long id;
    private Long doctorId;
    private List<DailyScheduleDTO> dailySchedules;

    // Конструктор для преобразования из сущности
    public WeeklyScheduleDTO(WeeklySchedule schedule) {
        this.id = schedule.getId();
        this.doctorId = schedule.getDoctor().getId();
        this.dailySchedules = schedule.getDailySchedules().stream()
                .map(DailyScheduleDTO::new)
                .collect(Collectors.toList());
    }

}
