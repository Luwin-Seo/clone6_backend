package com.example.clone6_backend.controller;

import com.example.clone6_backend.dto.response.FundResponseDto;
import com.example.clone6_backend.exceptionHandler.CustomException;
import com.example.clone6_backend.exceptionHandler.ErrorCode;
import com.example.clone6_backend.model.Fund;
import com.example.clone6_backend.repository.FundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class FundController {

    private final FundRepository fundRepository;

    //펀딩 상품 상세 조회
    @GetMapping("/api/fund/{fundId}")
    public FundResponseDto detailPage(@PathVariable Long fundId){
        Fund fund = fundRepository.findById(fundId).orElseThrow(()
                -> new CustomException(ErrorCode.FUND_NOT_FOUND));
        return new FundResponseDto(fund);
    }

}
