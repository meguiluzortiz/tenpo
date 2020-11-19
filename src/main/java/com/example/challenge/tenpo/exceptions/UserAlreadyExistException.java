package com.example.challenge.tenpo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class UserAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = -1298682622652730604L;

    public UserAlreadyExistException(String message) {
        super(message);
    }

}
