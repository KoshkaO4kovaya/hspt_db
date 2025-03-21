package com.hsptsdb.hospitalproject.hspt.service;

import com.hsptsdb.hospitalproject.hspt.dto.UserDTO;
import com.hsptsdb.hospitalproject.hspt.mapper.UserMapper;
import com.hsptsdb.hospitalproject.hspt.model.User;
import com.hsptsdb.hospitalproject.hspt.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService extends GenericService<User, UserDTO> {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(userRepository, userMapper);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public UserDTO registration(UserDTO userDTO) {
        if (userRepository.findUserByEmail(userDTO.getEmail()) != null) {
            throw new RuntimeException("Пользователь с таким email'ом уже существует"); //  исправить на кастомный эксепшн
        }
        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userDTO.setCreatedWhen(LocalDateTime.now());
        return mapper.toDTO(repository.save(mapper.toEntity(userDTO)));
    }
}
