package com.example.clone6_backend.model;

import com.example.clone6_backend.dto.request.FundRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Fund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fundId;

    @Column(nullable = false)
    private String title;

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


    public Fund(FundRequestDto fundRequestDto){
        this.category = fundRequestDto.getCategory();
        this.content = fundRequestDto.getContent();
        this.fundingGoal = fundRequestDto.getFundingGoal();
        this.currentFund = fundRequestDto.getCurrentFund();

    }

}
