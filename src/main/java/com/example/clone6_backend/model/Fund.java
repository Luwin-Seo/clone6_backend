package com.example.clone6_backend.model;

import com.example.clone6_backend.dto.response.FundResponseDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Entity
@Getter
public class Fund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fundId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String subTitle;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Long fundingGoal;

    @Column(nullable = false)
    private Long currentFund;

    @Column(nullable = false)
    private String imageURL;

    @Column(nullable = false)
    private LocalDateTime expDate;


    public Fund() {
        this.fundId = getFundId();
        this.title = getTitle();
        this.subTitle = getSubTitle();
        this.content = getContent();
        this.category = getCategory();
        this.fundingGoal = getFundingGoal();
        this.currentFund = getCurrentFund();
        this.imageURL = getImageURL();
        this.expDate = getExpDate();
    }

    public void detailPage(FundResponseDto fundResponseDto) {
        this.fundId = fundResponseDto.getFundId();
        this.title = fundResponseDto.getTitle();
        this.subTitle = fundResponseDto.getSubTitle();
        this.content = fundResponseDto.getContent();
        this.category = fundResponseDto.getCategory();
        this.fundingGoal = fundResponseDto.getFundingGoal();
        this.currentFund = fundResponseDto.getCurrentFund();
        this.imageURL = fundResponseDto.getImageURL();
        this.expDate = fundResponseDto.getExpDate();
    }
}
