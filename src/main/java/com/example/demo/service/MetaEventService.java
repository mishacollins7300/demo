package com.example.demo.service;

import com.example.demo.dto.MetaEventCreateRequest;
import com.example.demo.dto.MetaResponse;
import com.example.demo.mapper.MetaEventMapper;
import com.example.demo.model.Event;
import com.example.demo.model.MetaEvent;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.MetaEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MetaEventService {

    private final MetaEventRepository repository;
    private final MetaEventMapper mapper;
    private final EventRepository eventRepository;

    public List<MetaResponse> getMetaEventByEventId(UUID eventId) {
        var result = repository.findMetaEventByMetaId(eventId);
        return result.stream()
                .map(mapper::getMetaResponse)
                .toList();
    }

    public void createMetaEvent(UUID eventId, MetaEventCreateRequest request) {
        Event event = eventRepository.findById(eventId).orElseThrow();
        MetaEvent metaEvent = mapper.getMetaEvent(request);
        metaEvent.setMeta(event);
        repository.save(metaEvent);
    }
}
