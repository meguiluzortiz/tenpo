package com.example.challenge.tenpo.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Test")
@ApiResponses({ //
                @ApiResponse(code = 500, message = "Error") //
})
@RestController
@RequestMapping("/history")
public class HistoryController {

        @ApiOperation(value = "List user's operations history")
        @ApiResponses({ //
                        @ApiResponse(code = 404, message = "Not found"), //
        })
        @GetMapping("/{username}")
        public List<String> history( //
                        @ApiParam(value = "Username to look for", example = "test") //
                        @PathVariable String username //
        ) {
                return new ArrayList<>();
        }
}
