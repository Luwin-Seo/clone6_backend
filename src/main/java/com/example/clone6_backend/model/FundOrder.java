package com.example.clone6_backend.model;

import com.example.clone6_backend.dto.request.FundOrderRequestDto;
import com.example.clone6_backend.security.UserDetailsImpl;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FundOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fundOrderId;

    @Column
    private Long fundId;

    @Column
    private Long id;

    @Column
    private int patron;

    @Column
    private boolean isNameHidden;

    @Column
    private boolean isPriceHidden;

    public FundOrder(UserDetailsImpl userDetails, Long fundId, FundOrderRequestDto requestDto) {
        this.id = userDetails.getUser().getId();
        this.patron = requestDto.getPatron();
        this.isNameHidden = requestDto.isNameHidden();
        this.isPriceHidden = requestDto.isPriceHidden();
    }
}
