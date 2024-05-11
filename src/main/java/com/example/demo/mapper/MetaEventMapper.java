package com.example.demo.mapper;

import com.example.demo.dto.MetaEventCreateRequest;
import com.example.demo.dto.MetaResponse;
import com.example.demo.model.MetaEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MetaEventMapper {

    MetaResponse getMetaResponse(MetaEvent metaEvent);

    MetaEvent getMetaEvent(MetaEventCreateRequest request);
}
