package com.hsptsdb.hospitalproject.hspt.service;

import com.hsptsdb.hospitalproject.hspt.dto.RoleDTO;
import com.hsptsdb.hospitalproject.hspt.dto.UserDTO;
import com.hsptsdb.hospitalproject.hspt.mapper.GenericMapper;
import com.hsptsdb.hospitalproject.hspt.model.User;
import com.hsptsdb.hospitalproject.hspt.repository.GenericRepository;
import com.hsptsdb.hospitalproject.hspt.repository.UserRepository; // Import UserRepository
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;

@Slf4j
@Service
public class UserService extends GenericService<User, UserDTO>{

    private final UserRepository userRepository; // Inject UserRepository
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(GenericRepository<User> repository,
                       GenericMapper<User, UserDTO> mapper,
                       UserRepository userRepository, // Add UserRepository to constructor
                       BCryptPasswordEncoder passwordEncoder) {
        super(repository, mapper);
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO create(UserDTO newObject) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(1L);
        newObject.setRole(roleDTO);
        newObject.setPassword(passwordEncoder.encode(newObject.getPassword())); // Hash the password
        return mapper.toDTO(repository.save(mapper.toEntity(newObject)));
    }

    public UserDTO authenticate(String snils, String password) {
        User user = userRepository.findUserByEmail(snils); // Use findUserByEmail (assuming snils is used as username)
        if (user == null) {
            throw new NotFoundException("Пользователь с таким СНИЛС не найден");
        }

        if (passwordEncoder.matches(password, user.getPassword())) {
            return mapper.toDTO(user);
        } else {
            throw new IllegalArgumentException("Неверный пароль");
        }
    }
}
