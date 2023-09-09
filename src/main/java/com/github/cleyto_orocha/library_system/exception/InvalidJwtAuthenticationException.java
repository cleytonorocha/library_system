package com.github.cleyto_orocha.library_system.exception;

import org.springframework.security.core.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException{
    public InvalidJwtAuthenticationException(String message){
        super(message);
    }
}
