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
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long findId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String category;


    public Comment(CommentRequestDto requestDto, Long fundId, UserDetailsImpl userDetails) {
//        this.fundId = fundId;
//        this.comment = requestDto.getComment();
//        this.nickname = userDetails.getUser().getNickname();

    }
}
