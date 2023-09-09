package com.github.cleyto_orocha.library_system.controllers.error;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.cleyto_orocha.library_system.exception.IdError;
import com.github.cleyto_orocha.library_system.exception.InvalidJwtAuthenticationException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException) {
        return new ApiError(methodArgumentNotValidException.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList()));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IdError.class)
    public ApiError handlerIdError(IdError idError) {
        return new ApiError(idError.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    public InvalidJwtAuthenticationException handlerInvalidJwtAuthenticationException(IdError idError) {
        return new InvalidJwtAuthenticationException(idError.getMessage());
    }

}
