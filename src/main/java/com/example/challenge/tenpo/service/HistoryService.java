package com.example.challenge.tenpo.service;

import com.example.challenge.tenpo.exceptions.UserNotFoundException;
import com.example.challenge.tenpo.persistence.entities.History;
import com.example.challenge.tenpo.persistence.repository.HistoryRepository;
import com.example.challenge.tenpo.util.ValidationUtil;
import com.example.challenge.tenpo.web.dto.HistoryRequestDto;
import com.example.challenge.tenpo.web.dto.HistoryResponseDto;
import com.example.challenge.tenpo.web.filter.HistoryFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private ValidationUtil validationUtil;

    public void save(HistoryRequestDto request) {
        var entity = new History();
        entity.setUri(request.getUri());
        entity.setDatetime(request.getDatetime());
        entity.setUsername(request.getUsername());

        historyRepository.save(entity);
    }

    public Slice<HistoryResponseDto> findAllByUsername(String username, Pageable pageRequest) {
        if (!HistoryFilter.USER_ANNONYMOUS.equals(username) && !validationUtil.usernameExist(username)) {
            throw new UserNotFoundException("There is no user with that username: " + username);
        }
        return historyRepository.findByUsername(username, pageRequest) //
                .map(e -> {
                    var dto = new HistoryResponseDto();
                    dto.setUri(e.getUri());
                    dto.setDatetime(e.getDatetime());
                    dto.setUsername(e.getUsername());
                    return dto;
                });

    }
}
