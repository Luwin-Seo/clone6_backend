package com.example.clone6_backend.model;

import com.example.clone6_backend.dto.request.SignupRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String nickname;

    public User (SignupRequestDto requestDto) {
        this.username = requestDto.getUserEmail();
        this.password = requestDto.getPassword();
        this.nickname = requestDto.getNickname();
    }
}
