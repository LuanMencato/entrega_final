package com.crudBoilerplate.app.config.customExceptions;

public class UserListNotFoundException extends RuntimeException {
    public UserListNotFoundException(String message) {
        super(message);
    }
}
