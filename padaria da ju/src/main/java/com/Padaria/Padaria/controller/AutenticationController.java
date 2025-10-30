package com.Padaria.Padaria.controller;

import com.Padaria.Padaria.DTO.RegisterDTO;
import com.Padaria.Padaria.infrastructure.entitys.User;
import com.Padaria.Padaria.infrastructure.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AutenticationController {

    private final UserRepository repository;

    public AutenticationController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Validated RegisterDTO data) {
        if (this.repository.findByUsername(data.login()) != null) {
            return ResponseEntity.badRequest().body("Usuário já existe!");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password()); // corrigido "encade"
        User newUser = new User(data.login(), encryptedPassword, data.role());
        this.repository.save(newUser);
        return ResponseEntity.ok().body("Usuário registrado com sucesso!");
    }
}


