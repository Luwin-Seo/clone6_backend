package com.example.clone6_backend.dto.request;

import lombok.Getter;

@Getter
public class SignupRequestDto {
    private String userEmail;
    private String password;
    private String nickname;
}
