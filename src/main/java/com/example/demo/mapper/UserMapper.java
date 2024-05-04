package com.example.demo.mapper;

import com.example.demo.dto.UserGetResponse;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserUpdateRequest request);

    UserGetResponse toUserGetResponse(User user);
}
