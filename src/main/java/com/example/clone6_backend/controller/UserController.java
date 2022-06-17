package com.example.clone6_backend.controller;

import com.example.clone6_backend.dto.request.DupCheckRequestDto;
import com.example.clone6_backend.dto.request.SignupRequestDto;
import com.example.clone6_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signup(@Valid @RequestBody SignupRequestDto requestDto) {
        return userService.signup(requestDto);
    }

    @PostMapping("/dupCheck")
    public boolean dupCheck(@RequestBody DupCheckRequestDto requestDto) {
        return userService.dupCheck(requestDto);
    }

    @GetMapping("/test")
    public String hello () {
        return "Hello World!";
    }
}
