package com.example.clone6_backend.controller;

import com.example.clone6_backend.dto.request.DupCheckRequestDto;
import com.example.clone6_backend.dto.request.SignupRequestDto;
import com.example.clone6_backend.exceptionHandler.CustomException;
import com.example.clone6_backend.exceptionHandler.ErrorCode;
import com.example.clone6_backend.service.KakaoUserService;
import com.example.clone6_backend.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final KakaoUserService kakaoUserService;

    @PostMapping("/signup")
    public ResponseEntity signup(@Valid @RequestBody SignupRequestDto requestDto) {
        return userService.signup(requestDto);
    }

    @PostMapping("/dupCheck")
    public boolean dupCheck(@RequestBody DupCheckRequestDto requestDto) {
        return userService.dupCheck(requestDto);
    }

    @GetMapping("/user/kakao/callback")
    public ResponseEntity kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
            String token = kakaoUserService.kakaoLogin(code);
            response.addHeader("Authorization", "BEARER" + " " + token);
        return new ResponseEntity("카카오 사용자로 로그인 처리 되었습니다", HttpStatus.OK);
    }


    @GetMapping("/test")
    public String hello () {
        return "Hello World!";
    }
}
