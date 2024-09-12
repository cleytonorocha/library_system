package com.github.cleyto_orocha.library_system.controllers.error;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.cleyto_orocha.library_system.exception.CpfPresentException;
import com.github.cleyto_orocha.library_system.exception.IdError;
import com.github.cleyto_orocha.library_system.exception.InvalidJwtAuthenticationException;
import com.github.cleyto_orocha.library_system.exception.UserPresentException;

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
    public ApiError handlerIdError(IdError ex) {
        return new ApiError(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    public ApiError handlerInvalidJwtAuthenticationException(IdError ex) {
        return new ApiError(ex.getMessage());

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CpfPresentException.class)
    public ApiError handlerCpfPresentException(CpfPresentException ex) {
        return new ApiError(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserPresentException.class)
    public ApiError handlerCpfPresentException(UserPresentException ex) {
        return new ApiError(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ApiError handlerHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return new ApiError("Error sending parameters" + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException.class)
    public ApiError handleBadCredentialException(BadCredentialsException ex) {
        return new ApiError("Error when logging: " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiError handleAllExceptions(Exception ex) {
        return new ApiError("Error on server, please contact the developer team: " + ex.getMessage());
    }

}
