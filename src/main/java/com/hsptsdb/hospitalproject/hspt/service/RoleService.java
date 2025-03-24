package com.hsptsdb.hospitalproject.hspt.service;


import com.hsptsdb.hospitalproject.hspt.dto.RoleDTO;
import com.hsptsdb.hospitalproject.hspt.mapper.GenericMapper;
import com.hsptsdb.hospitalproject.hspt.model.Role;
import com.hsptsdb.hospitalproject.hspt.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends GenericService<Role, RoleDTO> {
    public RoleService(GenericRepository<Role> repository,
                       GenericMapper<Role, RoleDTO> mapper) {
        super(repository, mapper);
    }
}
