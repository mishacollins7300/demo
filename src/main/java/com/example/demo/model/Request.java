package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 100000, name = "fields")
    private String fields;

    @Column(length = 100000, name = "comments")
    private String comments;

    @Column(length = 100000, name = "status")
    private String status;

    @ManyToOne
    private Event request;

    @ManyToOne
    private User userRequest;
}
