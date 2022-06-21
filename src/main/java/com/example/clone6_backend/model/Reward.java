package com.example.clone6_backend.model;

import com.example.clone6_backend.dto.request.RewardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rewardId;

    @Column
    private Long fundId;

    @Column
    private String rewardTitle;

    @Column
    private String rewardContent;

    @Column
    private int price;

    @Column
    private int deliveryFee;

    @Column
    private int quantityLimit;

    @Column
    private int quantity;

    public Reward (RewardRequestDto requestDto){
        this.fundId = requestDto.getFundId();
        this.rewardTitle = requestDto.getRewardTitle();
        this.rewardContent = requestDto.getRewardContent();
        this.price = requestDto.getPrice();
        this.deliveryFee = requestDto.getDeliveryFee();;
        this.quantityLimit = requestDto.getQuantityLimit();
        this.quantity = requestDto.getQuantity();
    }

    public Reward(Long fundId, String rewardTitle, String rewardContent, int price, int deliveryFee, int quantityLimit, int quantity) {
        this.fundId = fundId;
        this.rewardTitle = rewardTitle;
        this.rewardContent = rewardContent;
        this.price = price;
        this.deliveryFee = deliveryFee;
        this.quantityLimit = quantityLimit;
        this.quantity = quantity;
    }
}
