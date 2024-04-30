package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
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