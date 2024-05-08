package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "metaEvent")
public class metaEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 100000, name = "rule")
    private String rule;

    @Column(length = 100000, name = "fields")
    private String fields;

    @Column(length = 100000, name = "name")
    private String name;

    @Column(name = "dateBegin")
    private Date dateBegin;

    @Column(name = "dateEnd")
    private Date dateEnd;

    @ManyToOne
    @NotNull
    private Event meta;

    @ManyToOne
    @NotNull
    private User userRequest;
}
