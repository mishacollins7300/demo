package com.example.demo.dto;

import com.example.demo.model.User;
import com.example.demo.model.metaEvent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {
    private UUID id;

    private String name;

    private String description;

    private String type;

    private Date dateBegin;

    private Date dateEnd;

    private String domen;

    private String city;

    private List<User> creators;

    private List<metaEvent> meta;
}
