package com.example.demo.model;

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
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 100000)
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "dateBegin")
    private Date dateBegin;

    @Column(name = "dateEnd")
    private Date dateEnd;

    @Column(name = "domen")
    private String domen;

    @Column(name = "city")
    private String city;

    @ManyToMany(mappedBy = "events")
    private List<User> creators = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<metaEvent> meta = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Request> request = new ArrayList<>();
}
