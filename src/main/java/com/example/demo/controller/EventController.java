package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EventController {
    private final EventService service;

    @PostMapping("/app/event")
    public EventCreateResponse createEvent(@RequestBody EventCreateRequest request) {
        service.create(request);
        return service.getEventByDomen(request.getDomen());
    }

    @GetMapping(value = "/app/event/{domen}")
    public EventResponse getEvents(@PathVariable("domen") String domen) {
        return service.getEvent(domen);
    }
}
