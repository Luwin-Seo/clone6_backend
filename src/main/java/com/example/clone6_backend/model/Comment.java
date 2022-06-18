package com.example.clone6_backend.model;

import com.example.clone6_backend.dto.response.CommentResponseDto;
import com.example.clone6_backend.dto.response.ReplyResponseDto;
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
    private Long findId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String category;




    public Comment(CommentResponseDto responseDto, Long fundId) {
        this.findId = fundId;
        this.content = responseDto.getContent();
        this.commentId = responseDto.getCommentId();
        this.category = responseDto.getCategory();
        this.id = responseDto.getId();
    }
}
