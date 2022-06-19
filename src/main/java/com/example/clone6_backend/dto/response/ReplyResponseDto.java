package com.example.clone6_backend.dto.response;

import com.example.clone6_backend.model.Reply;
import com.example.clone6_backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReplyResponseDto {
    private Long commentId;
    private Long replyId;
    private String replyContent;
    private String nickname;
    private LocalDateTime createAt;

    public ReplyResponseDto(Reply reply, User user){
        this.commentId = reply.getCommentId();
        this.replyId = reply.getReplyId();
        this.replyContent = reply.getReplyContent();
        this.nickname = user.getNickname();
        this.createAt = reply.getCreatedAt();
    }

}
