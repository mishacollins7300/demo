package com.example.demo.repository;

import com.example.demo.model.MetaEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MetaEventRepository extends JpaRepository<MetaEvent, UUID> {

    List<MetaEvent> findMetaEventByMetaId(UUID eventId);
}
