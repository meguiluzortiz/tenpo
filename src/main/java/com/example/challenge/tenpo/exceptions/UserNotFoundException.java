package com.example.challenge.tenpo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -9041772924875658823L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
