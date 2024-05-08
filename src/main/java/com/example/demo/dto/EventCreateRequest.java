package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventCreateRequest {
    private String name;

    private String description;

    private String type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateBegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateEnd;

    private String domen;

    private String city;

    private UUID user_id;
}
