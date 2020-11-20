package com.example.challenge.tenpo.web.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoryRequestDto {
    private String uri;

    private LocalDateTime datetime;

    private String username;
}
