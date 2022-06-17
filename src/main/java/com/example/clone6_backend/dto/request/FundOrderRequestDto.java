package com.example.clone6_backend.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class FundOrderRequestDto {
    private List<FundOrderDetailRequestDto> orderedRewards;
    private int patron;
    private boolean isNameHidden;
    private boolean isPriceHidden;
}
