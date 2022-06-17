package com.example.clone6_backend.dto.response;

import com.example.clone6_backend.model.Reply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.RequestEntity;

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

        this.replyContent = reply.getReplyContent();
    }
}
