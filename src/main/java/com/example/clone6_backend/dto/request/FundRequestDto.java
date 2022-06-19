package com.example.clone6_backend.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FundRequestDto {
    private String title;
    private String subTitle;
    private String content;
    private String category;
    private Long fundingGoal;
    private Long currentFund;
    private String imageURL;
    private LocalDateTime expDate;

}
