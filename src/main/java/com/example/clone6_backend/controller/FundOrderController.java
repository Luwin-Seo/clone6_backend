package com.example.clone6_backend.controller;

import com.example.clone6_backend.dto.request.FundOrderRequestDto;
import com.example.clone6_backend.dto.response.RewardResponseDto;
import com.example.clone6_backend.exceptionHandler.CustomException;
import com.example.clone6_backend.exceptionHandler.ErrorCode;
import com.example.clone6_backend.security.UserDetailsImpl;
import com.example.clone6_backend.service.FundOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FundOrderController {

    private final FundOrderService fundOrderService;

    @PostMapping("/api/fund/{fundId}")
    public List<RewardResponseDto> moneyFlex (
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @RequestBody FundOrderRequestDto requestDto,
            @PathVariable Long fundId)
    {
        if(userDetails == null) {throw new CustomException(ErrorCode.AUTH_TOKEN_NOT_FOUND);}
        return fundOrderService.fundOrder(userDetails, fundId, requestDto);
    }
}
