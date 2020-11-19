package com.example.challenge.tenpo.service;

import java.util.Collections;

import com.example.challenge.tenpo.persistence.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username) //
                .map(e -> User.withUsername(e.getUsername()) //
                        .password(e.getPassword()) //
                        .authorities(Collections.emptyList()) //
                        .build() //
                ) //
                .orElseThrow(() -> {
                    String message = String.format("No user found with username [%s].", username);
                    return new UsernameNotFoundException(message);
                });
    }

}
