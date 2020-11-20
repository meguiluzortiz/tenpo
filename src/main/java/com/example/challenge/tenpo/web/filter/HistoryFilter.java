package com.example.challenge.tenpo.web.filter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.challenge.tenpo.service.HistoryService;
import com.example.challenge.tenpo.web.dto.HistoryRequestDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class HistoryFilter extends OncePerRequestFilter {
    public static final String USER_ANNONYMOUS = "annonymous";

    @Autowired
    private HistoryService historyService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        var authentication = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
        String username = authentication.map(e -> ((User) e.getPrincipal()).getUsername()).orElse(USER_ANNONYMOUS);

        HistoryRequestDto history = new HistoryRequestDto();
        history.setUri(path);
        history.setDatetime(LocalDateTime.now());
        history.setUsername(username);

        historyService.save(history);

        filterChain.doFilter(request, response);
    }
}
