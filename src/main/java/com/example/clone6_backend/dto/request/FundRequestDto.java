package com.example.clone6_backend.dto.request;

import com.example.clone6_backend.dto.response.FundResponseDto;
import com.example.clone6_backend.model.Fund;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class FundRequestDto {
    private String title;
    private String content;
    private String category;
    private Long fundingGoal;
    private Long currentFund;
    private String imageURL;
    private LocalDateTime expDate;

}
