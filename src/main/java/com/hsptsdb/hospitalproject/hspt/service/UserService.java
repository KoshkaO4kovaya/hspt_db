package com.hsptsdb.hospitalproject.hspt.service;


import com.hsptsdb.hospitalproject.hspt.dto.RoleDTO;
import com.hsptsdb.hospitalproject.hspt.dto.UserDTO;
import com.hsptsdb.hospitalproject.hspt.mapper.GenericMapper;
import com.hsptsdb.hospitalproject.hspt.repository.GenericRepository;
import com.hsptsdb.hospitalproject.hspt.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Slf4j
@Service
public class UserService
        extends GenericService<User, UserDTO> {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JavaMailSender javaMailSender;

    public UserService(GenericRepository<User> repository,
                       GenericMapper<User, UserDTO> mapper,
                       BCryptPasswordEncoder bCryptPasswordEncoder, JavaMailSender javaMailSender) {
        super(repository, mapper);
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public UserDTO create(UserDTO newObject) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(1L);
        newObject.setRole(roleDTO);
        newObject.setPassword(bCryptPasswordEncoder.encode(newObject.getPassword()));
        newObject.setCreatedBy("REGISTRATION FORM");
        newObject.setCreatedWhen(LocalDateTime.now());
        return mapper.toDTO(repository.save(mapper.toEntity(newObject)));
    }

    public UserDTO createLibrarian(UserDTO newObject) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(2L);
        newObject.setRole(roleDTO);
        newObject.setCreatedBy("LIBRARIAN CREATION FORM");
        return create(newObject);
    }

//    public UserDTO getUserByLogin(final String login) {
//        return mapper.toDTO(((UserRepository) repository).findUserByLogin(login));
//    }
//
//    public UserDTO getUserByEmail(final String email) {
//        return mapper.toDTO(((UserRepository) repository).findUserByEmail(email));
//    }

    public boolean checkPassword(String password, UserDetails foundUser) {
        return bCryptPasswordEncoder.matches(password, foundUser.getPassword());
    }

//    public void sendChangePasswordEmail(final UserDTO userDTO) {
//        // Переписали для 11-й лекции (из-за cron)
//        UUID uuid = UUID.randomUUID();
//        log.info("Generated Token: {}", uuid);
//
//        userDTO.setChangePasswordToken(uuid.toString());
//        update(userDTO);
//
//        SimpleMailMessage mailMessage = MailUtils.createMailMessage(
//                userDTO.getEmail(),
//                MailConstants.MAIL_SUBJECT_FOR_REMEMBER_PASSWORD,
//                MailConstants.MAIL_MESSAGE_FOR_REMEMBER_PASSWORD + uuid
//        );
//
//        javaMailSender.send(mailMessage);
//    }
//
//    public void changePassword(String uuid, String password) {
//        UserDTO userDTO = mapper.toDTO(((UserRepository) repository).findUserByChangePasswordToken(uuid));
//
//        userDTO.setChangePasswordToken(null);
//        userDTO.setPassword(bCryptPasswordEncoder.encode(password));
//
//        update(userDTO);
//    }
//
//    public List<String> getUserEmailsWithDelayedRentDate() {
//        return ((UserRepository) repository).getDelayedEmails();
//    }
//
//    public Page<UserDTO> findUsers(UserDTO userDTO, Pageable pageable) {
//        Page<User> users = ((UserRepository) repository).searchUsers(
//                userDTO.getFirstName(),
//                userDTO.getLastName(),
//                userDTO.getLogin(),
//                pageable
//        );
//        List<UserDTO> result = mapper.toDTOs(users.getContent());
//        return new PageImpl<>(result, pageable, users.getTotalElements());
//    }

}