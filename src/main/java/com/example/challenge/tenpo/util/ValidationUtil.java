package com.example.challenge.tenpo.util;

import com.example.challenge.tenpo.persistence.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtil {

    @Autowired
    private UserRepository userRepository;

    public boolean usernameExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

}
