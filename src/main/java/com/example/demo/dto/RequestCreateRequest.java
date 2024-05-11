package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreateRequest {

    private String fields;

    private String status;

    @JsonProperty("event_id")
    private UUID eventId;

    @JsonProperty("user_id")
    private UUID userId;
}
