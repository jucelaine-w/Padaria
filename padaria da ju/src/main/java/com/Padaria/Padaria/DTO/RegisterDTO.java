package com.Padaria.Padaria.DTO;

import com.Padaria.Padaria.role.UserRole;

public record RegisterDTO(
        String login,
        String password,
        UserRole role
) {}

