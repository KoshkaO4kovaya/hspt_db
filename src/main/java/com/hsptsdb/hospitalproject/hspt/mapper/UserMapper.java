package com.hsptsdb.hospitalproject.hspt.mapper;

import com.hsptsdb.hospitalproject.hspt.dto.UserDTO;
import com.hsptsdb.hospitalproject.hspt.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
public class UserMapper extends GenericMapper<User, UserDTO> {

    public UserMapper(ModelMapper modelMapper) {
        super(User.class, UserDTO.class, modelMapper);
    }

    @Override
    protected void mapSpecificFields(UserDTO source, User destination) {
        // Специфическое мапирование, если необходимо
    }

    @Override
    protected void mapSpecificFields(User source, UserDTO destination) {
        // Специфическое мапирование, если необходимо
    }

    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(User.class, UserDTO.class)
                .addMappings(mapper -> mapper.skip(UserDTO::setPassword));
    }

    @Override
    protected List<Long> getIds(User entity) {
        return Collections.singletonList(entity.getId());
    }
}