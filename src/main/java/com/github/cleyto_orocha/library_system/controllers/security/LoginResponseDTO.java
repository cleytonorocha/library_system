package com.github.cleyto_orocha.library_system.controllers.security;

import lombok.Builder;

@Builder
public record LoginResponseDTO(String token) {}
