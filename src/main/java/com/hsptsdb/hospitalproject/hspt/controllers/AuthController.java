package com.hsptsdb.hospitalproject.hspt.controllers;

//import com.hsptsdb.hospitalproject.hspt.dto.LoginDTO;
import com.hsptsdb.hospitalproject.hspt.dto.UserDTO;
import com.hsptsdb.hospitalproject.hspt.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@Tag(name = "Контроллер для аутентификации и регистрации")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    @Operation(summary = "Регистрация пользователя", description = "Позволяет пользователю зарегистрироваться в системе.")
    public ResponseEntity<UserDTO> registration(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.registration(userDTO));
    }

//    @PostMapping("/login")
//    @Operation(summary = "Аутентификация", description = "Позволяет пользователю войти в систему")
//    public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDTO) {
//        return ResponseEntity.ok(userService.authenticate(loginDTO.getLogin(), loginDTO.getPassword()));
//    }
}
