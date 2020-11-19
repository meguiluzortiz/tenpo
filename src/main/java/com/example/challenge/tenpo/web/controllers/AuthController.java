package com.example.challenge.tenpo.web.controllers;

import javax.validation.Valid;

import com.example.challenge.tenpo.service.UserService;
import com.example.challenge.tenpo.web.dto.LoginRequestDto;
import com.example.challenge.tenpo.web.dto.LoginResponseDto;
import com.example.challenge.tenpo.web.dto.SignupRequestDto;
import com.example.challenge.tenpo.web.dto.SignupResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Security")
@ApiResponses({ //
        @ApiResponse(code = 500, message = "Error") //
})
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    @ApiOperation(value = "Create new user")
    @ApiResponses({ //
            @ApiResponse(code = 400, message = "Bad Request") //
    })
    public SignupResponseDto signup(@RequestBody @Valid SignupRequestDto request) {
        String username = userService.createUser(request);
        return new SignupResponseDto(username);
    }

    @PostMapping("/login")
    @ApiOperation(value = "Authenticate a user")
    @ApiResponses({ //
            @ApiResponse(code = 400, message = "Bad Request") //
    })
    public LoginResponseDto login(@RequestBody @Valid LoginRequestDto request) {
        return new LoginResponseDto("token");
    }
}
