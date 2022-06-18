package com.example.clone6_backend.model;

import com.example.clone6_backend.dto.request.RewardRequsetDto;
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

    @Column int quantity;

    public Reward (RewardRequsetDto requsetDto){
        this.fundId = requsetDto.getFundId();
        this.rewardTitle = requsetDto.getRewardTitle();
        this.rewardContent = requsetDto.getRewardContent();
        this.price = requsetDto.getPrice();
        this.deliveryFee = requsetDto.getDeliveryFee();;
        this.quantityLimit = requsetDto.getQuantityLimit();
        this.quantity = requsetDto.getQuantity();
    }
}
