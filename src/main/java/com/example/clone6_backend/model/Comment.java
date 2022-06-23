package com.example.clone6_backend.model;

import com.example.clone6_backend.dto.request.CommentRequestDto;
import com.example.clone6_backend.security.UserDetailsImpl;
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
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long fundId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String nickname;


    public Comment(CommentRequestDto requestDto, Long fundId, UserDetailsImpl userDetails) {
        this.id = userDetails.getUser().getId();
        this.fundId = fundId;
        this.content = requestDto.getContent();
        this.nickname = userDetails.getUser().getNickname();
        this.category = requestDto.getCategory();

    }



    public void update(CommentRequestDto requestDto, UserDetailsImpl userDetails) {
//        this.fundId = requestDto.getFundId();
        this.content = requestDto.getContent();
//        this.nickname = requestDto.getNickname();
        this.category = requestDto.getCategory();
        this.id = userDetails.getUser().getId();
    }

}
