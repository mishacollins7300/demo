package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserGetResponse {

    private UUID id;
    private String familiya;
    private String imya;
    private String otchestvo;
    private String dataRogdeniya;
    private String phone;
    private String email;
    private String role;
    private String avatar;
    private String username;
    private String nickname;
}