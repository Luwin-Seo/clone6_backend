package com.example.clone6_backend.dto.response;

import com.example.clone6_backend.model.Reply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReplyResponseDto {
    private Long commentId;
    private Long replyId;
    private String replyContent;
    private String nickname;
    private String createAt;

    public ReplyResponseDto(Reply reply) {
        this.commentId = reply.getCommentId();
        this.replyId = reply.getReplyId();
        this.replyContent = reply.getReplyContent();
    }

}
