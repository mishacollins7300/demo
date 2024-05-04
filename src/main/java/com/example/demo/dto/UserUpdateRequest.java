package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {

    @NotBlank
    private UUID id;

    private String email;

    private String familiya;

    private String imya;

    private String otchestvo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataRogdeniya;

    private String phone;

    private String nickname;
}
