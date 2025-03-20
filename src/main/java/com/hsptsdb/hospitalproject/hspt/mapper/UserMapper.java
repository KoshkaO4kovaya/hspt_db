package com.hsptsdb.hospitalproject.hspt.mapper;


import com.hsptsdb.hospitalproject.hspt.dto.RoleDTO;
import com.hsptsdb.hospitalproject.hspt.dto.UserDTO;
import com.hsptsdb.hospitalproject.hspt.model.Role;
import com.hsptsdb.hospitalproject.hspt.model.User;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper extends GenericMapper<User, UserDTO>{


    public UserMapper(ModelMapper modelMapper) {
        super(User.class, UserDTO.class, modelMapper);
    }

    @Override
    @PostConstruct
    protected void setupMapper() {
        modelMapper.createTypeMap(UserDTO.class, User.class)
                .addMappings(m -> m.skip(User::setRole))
                .setPostConverter(toEntityConverter());
        modelMapper.createTypeMap(User.class, UserDTO.class)
                .addMappings(m -> m.skip(UserDTO::setRole))
                .setPostConverter(toDTOConverter());
    }

    @Override
    protected void mapSpecificFields(UserDTO source, User destination) {
        if (source.getRole() != null) {
            destination.setRole(modelMapper.map(source.getRole(), Role.class));
        }
    }

    @Override
    protected void mapSpecificFields(User source, UserDTO destination) {
        if (source.getRole() != null) {
            destination.setRole(modelMapper.map(source.getRole(), RoleDTO.class));
        }
    }

    @Override
    protected List<Long> getIds(User entity) {
        List<Long> ids = new ArrayList<>();
        if (entity != null && entity.getRole() != null && entity.getRole().getId() != null) {
            ids.add(entity.getRole().getId());
        }
        return ids;
    }

}
