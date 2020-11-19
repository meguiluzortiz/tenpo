package com.example.challenge.tenpo.web.controllers;

import com.example.challenge.tenpo.web.dto.SumRequestDto;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Api(tags = "Test")
@ApiResponses({ //
        @ApiResponse(code = 500, message = "Error") //
})
@RestController
@RequestMapping("/math")
public class MathController {

    @ApiOperation(value = "Sum two numbers", authorizations = @Authorization("JWT"))
    @ApiResponses({ //
            @ApiResponse(code = 400, message = "Bad Request"), //
            @ApiResponse(code = 403, message = "Forbidden") //
    })
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/sum")
    public int sum(@RequestBody SumRequestDto request) {
        return request.getNumber1() + request.getNumber2();
    }
}
