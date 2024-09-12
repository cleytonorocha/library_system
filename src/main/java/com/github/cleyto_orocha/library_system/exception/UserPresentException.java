package com.github.cleyto_orocha.library_system.exception;

public class UserPresentException extends RuntimeException {
    public UserPresentException() {
        super("Already registered user");
    }
}
