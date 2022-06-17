package com.example.clone6_backend.dto.response;

import com.example.clone6_backend.model.Reward;

public class RewardResponseDto {
    private Long rewardId;
    private Long fundId;
    private String rewardTitle;
    private String rewardContent;
    private int price;
    private int deliveryFee;
    private int quantityLimit;
    private int quantity;

    public RewardResponseDto(Reward reward) {
        this.rewardId = reward.getRewardId();
        this.fundId = reward.getFundId();
        this.rewardTitle = reward.getRewardTitle();
        this.rewardContent = reward.getRewardContent();
        this.price = reward.getPrice();
        this.deliveryFee = reward.getDeliveryFee();;
        this.quantityLimit = reward.getQuantityLimit();
        this.quantity = reward.getQuantity();
    }
}
