package com.example.demo.controller;

import com.example.demo.dto.RequestCreateRequest;
import com.example.demo.dto.RequestResponse;
import com.example.demo.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RequestController {

    private final RequestService service;

    @PostMapping("/app/request")
    public RequestResponse createRequest(@RequestBody RequestCreateRequest request) {
        return service.createRequest(request);
    }
}
