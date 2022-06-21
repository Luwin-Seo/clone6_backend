package com.example.clone6_backend.model;

import com.example.clone6_backend.dto.request.LikeRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fund_id")
    private Fund fund;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Likes(LikeRequestDto likeRequestDto) {
        this.fund = likeRequestDto.getFund();
        this.user = likeRequestDto.getUser();
    }

}
