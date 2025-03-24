package com.hsptsdb.hospitalproject.hspt.service;

import com.hsptsdb.hospitalproject.hspt.dto.RoleDTO;
import com.hsptsdb.hospitalproject.hspt.dto.UserDTO;
import com.hsptsdb.hospitalproject.hspt.mapper.GenericMapper;
import com.hsptsdb.hospitalproject.hspt.model.User;
import com.hsptsdb.hospitalproject.hspt.repository.GenericRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class UserService extends GenericService<User, UserDTO>{
    public UserService(GenericRepository<User> repository,
                       GenericMapper<User, UserDTO> mapper) {
        super(repository, mapper);
    }

    @Override
    public UserDTO create(UserDTO newObject) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(1L);
        newObject.setRole(roleDTO);
        return mapper.toDTO(repository.save(mapper.toEntity(newObject)));
    }
}