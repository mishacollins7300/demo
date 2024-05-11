package com.example.demo.dto;

import com.example.demo.model.Event;
import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestResponse {

    private UUID id;

    private String fields;

    private String status;

    @JsonProperty("event_id")
    private UUID eventId;

    private List<UserGetResponse> users;
}
