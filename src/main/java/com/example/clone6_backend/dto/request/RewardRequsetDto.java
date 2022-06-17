package com.example.clone6_backend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RewardRequsetDto {
    private Long fundId;
    private String rewardTitle;
    private String rewardContent;
    private int price;
    private int deliveryFee;
    private int quantityLimit;
    private int quantity;
}
