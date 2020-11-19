package com.example.challenge.tenpo.web.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {

    @NotEmpty
    @Size(min = 4, max = 8)
    @ApiModelProperty(example = "test")
    private String username;

    @NotEmpty
    @Size(min = 4, max = 12)
    @ApiModelProperty(example = "test")
    private String password;

}
