package com.example.demo.controller;

import com.example.demo.auth.JwtService;
import com.example.demo.dto.UserGetResponse;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/app/user")
    public UserGetResponse getUserData() {
	var user = service.getCurrentUser();
	return UserGetResponse.builder()
		.dataRogdeniya(user.getDataRogdeniya() == null ?
			null :
			new SimpleDateFormat("yyyy-MM-dd").format(user.getDataRogdeniya()))
		.role(user.getRole().name())
		.id(user.getId())
		.phone(user.getPhone())
		.avatar(user.getAvatar())
		.imya(user.getImya())
		.familiya(user.getFamiliya())
		.otchestvo(user.getOtchestvo())
		.nickname(user.getNickname())
		.email(user.getEmail())
		.username(user.getUsername())
		.build();
    }

	@PutMapping("/app/user")
	public UserGetResponse updateUser(@RequestBody UserUpdateRequest request) {
		service.updateUser(request);
		return service.getUserById(request.getId());
	}
}
