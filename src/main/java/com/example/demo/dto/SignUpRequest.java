package com.example.demo.dto;

import com.example.demo.model.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Schema(description = "Запрос на регистрацию")
public class SignUpRequest {

    @Schema(description = "Логин", example = "Jon")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;

    @Schema(description = "Адрес электронной почты", example = "jondoe@gmail.com")
    @NotBlank(message = "Адрес электронной почты не может быть пустыми")
    @Email(message = "Email адрес должен быть в формате user@example.com")
    private String email;

    @Schema(description = "Пароль", example = "my_1secret1_password")
    @Size(max = 255, message = "Длина пароля должна быть не более 255 символов")
    private String password;

    @Schema(description = "Фамилия", example = "Jon")
    @NotBlank(message = "Фамилия не может быть пустыми")
    private String familiya;

    @Schema(description = "Имя", example = "Jon")
    @NotBlank(message = "Имя  не может быть пустыми")
    private String imya;

    @Schema(description = "Отчество", example = "Jon")
    private String otchestvo;

    @Schema(description = "Имя пользователя", example = "Jon")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataRogdeniya;

    @Schema(description = "Телефон", example = "Jon")
    @NotBlank(message = "Телефон не может быть пустыми")
    private String phone;

    @Schema(description = "Никнейм", example = "Jon")
    @NotBlank(message = "Никнейм не может быть пустыми")
    private String nickname;

}
