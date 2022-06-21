package com.example.clone6_backend.model;

import com.example.clone6_backend.dto.request.FundRequestDto;
import com.example.clone6_backend.dto.response.FundResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Entity
@Getter
@NoArgsConstructor
public class Fund extends Timestamped {

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
    private LocalDate expDate;


    public Fund(FundRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.subTitle = requestDto.getSubTitle();
        this.content = requestDto.getContent();
        this.category = requestDto.getCategory();
        this.fundingGoal = requestDto.getFundingGoal();
        this.currentFund = requestDto.getCurrentFund();
        this.imageURL = requestDto.getImageURL();
        this.expDate = requestDto.getExpDate();
    }

    public Fund(String title, String subTitle, String content, String category, Long fundingGoal, Long currentFund, String imageURL, LocalDate expDate) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.category = category;
        this.fundingGoal = fundingGoal;
        this.currentFund = currentFund;
        this.imageURL = imageURL;
        this.expDate = expDate;
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
