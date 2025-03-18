package com.hsptsdb.hospitalproject.hspt.dto;

import com.hsptsdb.hospitalproject.hspt.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class ServiceDTO
        extends GenericDTO {
    private String categoryTitle;
    private LocalDate publishDate;
    private String description;
    private Category category;
    private List<Long> doctorIds;
    private List<DoctorDTO> dctorInfo;
}

