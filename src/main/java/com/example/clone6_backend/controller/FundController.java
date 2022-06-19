package com.example.clone6_backend.controller;

import com.example.clone6_backend.dto.request.FundRequestDto;
import com.example.clone6_backend.dto.response.FundResponseDto;
import com.example.clone6_backend.model.Fund;
import com.example.clone6_backend.repository.FundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class FundController {

    private final FundRepository fundRepository;

    //펀딩 상품 상세 조회
    @GetMapping("/api/fund/{fundId}")
    public FundResponseDto detailPage(@PathVariable Long fundId){
        Fund fund = fundRepository.findByFundId(fundId);
        return new FundResponseDto(fund);
    }

    @PostMapping("/test/fund")
    public ResponseEntity createFund (@RequestBody FundRequestDto requestDto) {
        fundRepository.save(new Fund(requestDto));
        return new ResponseEntity("세팅값이 저장되었습니다", HttpStatus.OK);
    }

}
