package com.hsptsdb.hospitalproject.hspt.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RoleDTO  extends GenericDTO  {
    private String title;
    private String description;
}
