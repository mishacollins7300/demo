package com.example.demo.controller;

import com.example.demo.dto.MetaEventCreateRequest;
import com.example.demo.dto.MetaResponse;
import com.example.demo.service.MetaEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MetaEventController {

    private final MetaEventService service;

    // get meta by event id
    @GetMapping("/app/event/{eventId}/meta")
    public List<MetaResponse> getMetaEventInformation(@PathVariable UUID eventId) {
        return service.getMetaEventByEventId(eventId);
    }

    @PostMapping("/app/event/{eventId}/meta")
    public List<MetaResponse> createMetaEvent(@PathVariable UUID eventId,
                                              @RequestBody MetaEventCreateRequest request) {
        service.createMetaEvent(eventId, request);
        return service.getMetaEventByEventId(eventId);
    }
}
