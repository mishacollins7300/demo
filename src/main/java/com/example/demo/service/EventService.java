package com.example.demo.service;

import com.example.demo.dto.EventCreateRequest;
import com.example.demo.dto.EventCreateResponse;
import com.example.demo.dto.EventResponse;
import com.example.demo.mapper.EventMapper;
import com.example.demo.model.Event;
import com.example.demo.model.User;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository repository;
    private final EventMapper mapper;
    private final UserRepository userRepository;

    public Event save(EventCreateRequest request) {
        Event event = new Event();
        event.setId(UUID.randomUUID());
        event.setName(request.getName());
        event.setDescription(request.getDescription());
        event.setCity(request.getCity());
        event.setDomen(request.getDomen());
        event.setType(request.getType());
        event.setDateEnd(request.getDateEnd());
        event.setDateBegin(request.getDateBegin());
        User user = userRepository.findById(request.getUser_id()).orElse(null);
        var result = repository.save(event);
        user.getEvents().add(result);
        userRepository.save(user);
        return result;
    }

    public Event create(EventCreateRequest event) {
        if(repository.existsByDomen(event.getDomen())) {
            throw new RuntimeException("Такой домен уже существует");
        }
        return save(event);
    }

    public EventCreateResponse getEventByDomen(String domen) {
        Event event = repository.findByDomen(domen).orElse(null);
        if (event == null) {
            return null;
        }
        EventCreateResponse response = new EventCreateResponse();
        response.setDomen(event.getDomen());
        return response;
    }

    public EventResponse getEvent(String domen) {
        Event event = repository.findByDomen(domen).orElse(null);
        return event == null ? null : mapper.toEventGetResponse(event);
    }

    public List<EventResponse> getEventsByUserId(UUID userId) {
        var result = repository.findEventsByCreatorsId(userId);
        return result.stream()
                .map(mapper::toEventGetResponse)
                .toList();
    }
}
