package com.example.demo.mapper;

import com.example.demo.dto.EventResponse;
import com.example.demo.model.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventResponse toEventGetResponse(Event event);
}
