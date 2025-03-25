package com.hsptsdb.hospitalproject.hspt.controllers;

import com.hsptsdb.hospitalproject.hspt.dto.RoleDTO;
import com.hsptsdb.hospitalproject.hspt.model.Role;
import com.hsptsdb.hospitalproject.hspt.service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@Tag(name = "Роли",description = "Контроллер для работы с ролями компании")
public class RoleController extends GenericController<Role, RoleDTO> {

    public RoleController(RoleService roleService) {
        super(roleService);
    }
}
