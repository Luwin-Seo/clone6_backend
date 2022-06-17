package com.example.clone6_backend.dto.response;

import com.example.clone6_backend.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {
    private Long fundId;

    private Long commentId;

    private String content;

    private String category;

    private String createAt;

    public CommentResponseDto(Comment comment) {
        this.fundId = comment.getCommentId();


    }
}
