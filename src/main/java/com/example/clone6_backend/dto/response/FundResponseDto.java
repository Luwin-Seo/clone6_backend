package com.example.clone6_backend.dto.response;

import com.example.clone6_backend.model.Fund;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FundResponseDto {
    private Long fundId;
    private String title;
    private String content;
    private String category;
    private Long fundingGoal;
    private Long currentFund;
    private String imageURL;
    private LocalDateTime expDate;

    public FundResponseDto(Fund fund) {
        this.fundId = fund.getFundId();
        this.title = fund.getTitle();
        this.content = fund.getContent();
        this.category = fund.getCategory();
        this.fundingGoal = fund.getFundingGoal();
        this.currentFund = fund.getCurrentFund();
        this.imageURL = fund.getImageURL();
        this.expDate = fund.getExpDate();
    }
}
