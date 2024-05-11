package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MetaEventCreateRequest {

    private UUID id;

    private String rule;

    private String fields;

    private String name;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date dateBegin;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date dateEnd;
}
