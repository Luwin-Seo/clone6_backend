package com.example.clone6_backend.service;

import com.example.clone6_backend.dto.response.FundResponseDto;
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
    public List<FundResponseDto> getFunds(Long fundId){
        List<FundResponseDto> fundResponseDtoList = new ArrayList<>();
        
    }


    //펀딩 상품 상세 조회


}
