package com.example.demo.repository;

import com.example.demo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID>{
    Optional<Event> findByDomen(String domen);
    boolean existsByDomen(String domen);
    List<Event> findEventsByCreatorId(UUID userId);
}
