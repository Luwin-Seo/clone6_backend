package com.example.clone6_backend.service;

import com.example.clone6_backend.dto.response.FundResponseDto;
import com.example.clone6_backend.exceptionHandler.CustomException;
import com.example.clone6_backend.exceptionHandler.ErrorCode;
import com.example.clone6_backend.model.Fund;
import com.example.clone6_backend.repository.FundRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Setter
@RequiredArgsConstructor
public class FundService {

    private final FundRepository fundRepository;

    //펀딩 상품 전체 조회
    public List<FundResponseDto> homePage() {
        List<FundResponseDto> fundResponseDtoList = new ArrayList<>();
        List<Fund> fundList = fundRepository.findAll();
        for (int i = 0; i < fundList.size(); i++) {
            Fund fund = fundList.get(i);
            FundResponseDto responseDto = new FundResponseDto(fund);
            fundResponseDtoList.add(responseDto);
        }
        return fundResponseDtoList;
    }

    /*
    //펀딩 상품 상세 조회
    public Long detailPage(Long fundId, FundResponseDto fundResponseDto) {
        Fund fund = fundRepository.findById(fundId).orElseThrow(
                () -> new CustomException(ErrorCode.FUND_NOT_FOUND));
        fund.detailPage(fundResponseDto);
        return fund.getFundId();
    } */
}
