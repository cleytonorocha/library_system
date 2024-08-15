package com.github.cleyto_orocha.library_system.controllers.dto;

import com.github.cleyto_orocha.library_system.enums.UserRole;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;

public record RegisterDTO(
        @Schema(example = "Cleyton") String login,
        @Schema(example = "admin") String password,
        @Hidden UserRole role) {
}
