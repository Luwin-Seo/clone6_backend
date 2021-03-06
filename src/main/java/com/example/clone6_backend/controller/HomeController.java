package com.example.clone6_backend.controller;

import com.example.clone6_backend.dto.response.FundResponseDto;
import com.example.clone6_backend.service.FundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final FundService fundService;

    //메인페이지 펀딩 상품들 전체 조회
    @GetMapping("/api/home")
    public List<FundResponseDto> homePage() {
        return fundService.homePage();
    }

}

