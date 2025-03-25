package com.hsptsdb.hospitalproject.hspt.controllers;

import com.hsptsdb.hospitalproject.hspt.dto.LoginDTO;
import com.hsptsdb.hospitalproject.hspt.dto.UserDTO;
import com.hsptsdb.hospitalproject.hspt.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@Tag(name = "Контроллер для работы с юзерами")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Регистрация пользователя", description = "Позволяет пользователю зарегистрироваться в системе.")
    @PostMapping("/registration")
    public ResponseEntity<UserDTO> registration(@Valid @RequestBody UserDTO userDTO) {
        log.info("Received registration request: {}", userDTO); // <- Добавляем логирование
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.create(userDTO));
    }
    @Operation(summary = "Аутентификация пользователя", description = "Аутентифицирует пользователя по логину и паролю.")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            UserDTO userDTO = userService.authenticate(loginDTO.getSnils(), loginDTO.getPassword());
            return ResponseEntity.ok(userDTO); // Возвращаем данные пользователя при успехе
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверные логин или пароль"); // Обработка ошибки
        }
    }
}