package com.example.demo.dto;

import com.example.demo.model.User;
import com.example.demo.model.MetaEvent;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateBegin;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateEnd;

    private String domen;

    private String city;

    private List<MetaEvent> meta;
}
