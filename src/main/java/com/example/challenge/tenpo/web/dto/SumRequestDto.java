package com.example.challenge.tenpo.web.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumRequestDto {

    @Digits(integer = 2, fraction = 0)
    @Min(value = 0)
    @ApiModelProperty(example = "1")
    private int number1;

    @Digits(integer = 2, fraction = 0)
    @Min(value = 0)
    @ApiModelProperty(example = "1")
    private int number2;
}
