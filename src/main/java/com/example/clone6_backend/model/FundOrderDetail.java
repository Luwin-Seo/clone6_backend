package com.example.clone6_backend.model;

import com.example.clone6_backend.dto.request.FundOrderDetailRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FundOrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fundOrderDetailId;

    @Column
    private Long fundOrderId;

    @Column
    private Long rewardId;

    @Column
    private int quantity;

    public FundOrderDetail (Long fundOrderId, FundOrderDetailRequestDto requestDto) {
        this.fundOrderId = fundOrderId;
        this.rewardId = requestDto.getRewardId();
        this.quantity = requestDto.getQuantity();
    }
}
