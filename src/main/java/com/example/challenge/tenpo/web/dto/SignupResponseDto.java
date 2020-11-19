package com.example.challenge.tenpo.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupResponseDto {

    @ApiModelProperty(example = "test")
    private String username;
}
