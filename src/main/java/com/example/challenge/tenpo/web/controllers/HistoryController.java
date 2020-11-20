package com.example.challenge.tenpo.web.controllers;

import com.example.challenge.tenpo.service.HistoryService;
import com.example.challenge.tenpo.web.dto.HistoryResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

        @Value("${application.history.page.size}")
        private Integer pageSize;

        @Autowired
        private HistoryService historyService;

        @ApiOperation(value = "List user's operations history")
        @ApiResponses({ //
                        @ApiResponse(code = 404, message = "Not found"), //
        })
        @GetMapping("/{username}")
        public Slice<HistoryResponseDto> findAllByUsername( //
                        @ApiParam(value = "Username to look for", example = "test") //
                        @PathVariable String username, //
                        @RequestParam(defaultValue = "0") int page) {
                Pageable pageRequest = PageRequest.of(page, pageSize);
                return historyService.findAllByUsername(username, pageRequest);
        }
}
