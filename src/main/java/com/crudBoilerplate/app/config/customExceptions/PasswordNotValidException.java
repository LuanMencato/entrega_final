package com.crudBoilerplate.app.config.customExceptions;

public class PasswordNotValidException extends RuntimeException{
    public PasswordNotValidException(String message){
        super(message);
    }
}
