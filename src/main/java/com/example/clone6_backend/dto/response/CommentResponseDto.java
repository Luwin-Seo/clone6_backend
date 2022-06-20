package com.example.clone6_backend.dto.response;

import com.example.clone6_backend.model.Comment;
import com.example.clone6_backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {
    private Long fundId;

    private Long commentId;

    private String nickname;

    private String content;

    private String category;

    private LocalDateTime createAt;

        //원투메니 연습 한다고 주석 한거임
    private List<ReplyResponseDto> replyResponseDto;


    public CommentResponseDto(Comment comment, User user) {
        this.fundId = comment.getFundId();
        this.commentId = comment.getCommentId();
        this.nickname = user.getNickname();
        this.content = comment.getContent();
        this.category = comment.getCategory();
        this.createAt = comment.getCreatedAt();
    }
    public CommentResponseDto(Comment comment) {
        this.fundId = comment.getFundId();
        this.commentId = comment.getCommentId();
        this.nickname = comment.getNickname();
        this.content = comment.getContent();
        this.category = comment.getCategory();
        this.createAt = comment.getCreatedAt();
    }


}
