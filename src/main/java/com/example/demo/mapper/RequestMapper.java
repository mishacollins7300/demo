package com.example.demo.mapper;

import com.example.demo.dto.RequestCreateRequest;
import com.example.demo.dto.RequestResponse;
import com.example.demo.model.Request;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    Request toRequest(RequestCreateRequest request);

    RequestResponse toRequestResponse(Request request);
}
