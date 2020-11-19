package com.example.challenge.tenpo.service;

import com.example.challenge.tenpo.exceptions.UserAlreadyExistException;
import com.example.challenge.tenpo.persistence.entities.User;
import com.example.challenge.tenpo.persistence.repository.UserRepository;
import com.example.challenge.tenpo.web.dto.SignupRequestDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public String createUser(SignupRequestDto request) throws UserAlreadyExistException {
        String username = request.getUsername();
        if (usernameExist(username)) {
            throw new UserAlreadyExistException("There is already an user with that username: " + username);
        }

        var user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        var savedUser = userRepository.save(user);
        return savedUser.getUsername();
    }

    private boolean usernameExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
