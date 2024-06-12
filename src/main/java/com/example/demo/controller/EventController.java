package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class EventController {
    private final EventService service;

    @PostMapping("/app/event")
    public EventCreateResponse createEvent(@RequestBody EventCreateRequest request) {
        service.create(request);
        return service.getEventByDomen(request.getDomen());
    }

    @GetMapping("/app/event")
    public EventResponse getEvents(@RequestParam("domen") String domen) {
        return service.getEvent(domen);
    }

    @GetMapping("/app/event/user/{userId}")
    public List<EventResponse> getEventsByUserId(@PathVariable UUID userId) {
        return service.getEventsByUserId(userId);
    }

    @GetMapping("/app/event/{eventId}")
    public EventResponse getEventById(@PathVariable UUID eventId) {
        return service.getEventById(eventId);
    }

    @GetMapping("/app/events")
    public List<EventResponse> getAllEvents() {
        return service.getAllEvents();
    }
}
