package com.github.cleyto_orocha.library_system.controllers.dto;

import com.github.cleyto_orocha.library_system.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
