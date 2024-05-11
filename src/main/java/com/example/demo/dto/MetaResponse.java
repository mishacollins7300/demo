package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Builder
@Data
public class MetaResponse {

    private UUID id;

    private String rule;

    private String fields;

    private String name;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date dateBegin;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date dateEnd;
}
