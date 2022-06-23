package com.example.clone6_backend.dto.request;

import com.example.clone6_backend.model.Fund;
import com.example.clone6_backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LikeRequestDto {
    private User user;
    private Fund fund;


}
