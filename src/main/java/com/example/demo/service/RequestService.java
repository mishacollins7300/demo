package com.example.demo.service;

import com.example.demo.dto.RequestCreateRequest;
import com.example.demo.dto.RequestResponse;
import com.example.demo.mapper.RequestMapper;
import com.example.demo.model.Event;
import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.RequestRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository repository;
    private final RequestMapper mapper;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public RequestResponse createRequest(RequestCreateRequest request) {
        Request entity = mapper.toRequest(request);
        Event event = eventRepository.findById(request.getEventId()).orElseThrow();
        User user = userRepository.findById(request.getUserId()).orElseThrow();

        entity.getUsers().add(user);
        entity.setEvent(event);
        return mapper.toRequestResponse(repository.save(entity));
    }
}
