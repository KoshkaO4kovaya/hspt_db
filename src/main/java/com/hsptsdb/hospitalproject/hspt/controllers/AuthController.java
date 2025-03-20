package com.hsptsdb.hospitalproject.hspt.controllers;


import com.hsptsdb.hospitalproject.hspt.dto.UserDTO;
import com.hsptsdb.hospitalproject.hspt.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Slf4j
@Tag(name = "Auth Controller", description = "Контроллер для аутентификации и авторизации")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/registration")
    @Operation(summary = "Регистрация пользователя", description = "Позволяет зарегистрировать нового пользователя")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
        log.info("Start registering user {}", userDTO.getEmail());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.create(userDTO));
    }

}
