package com.example.clone6_backend.dto.response;

import com.example.clone6_backend.model.Reply;
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

    public ReplyResponseDto(Reply reply){
        this.commentId = reply.getCommentId();
        this.replyId = reply.getReplyId();
        this.replyContent = reply.getReplyContent();
        this.nickname = reply.getNickname();
        this.createAt = reply.getCreatedAt();
    }


}
