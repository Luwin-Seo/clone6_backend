package com.example.clone6_backend.dto.response;

import com.example.clone6_backend.dto.request.FundOrderDetailRequestDto;
import com.example.clone6_backend.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {
    private Long fundId;

    private Long commentId;

    private Long id;

    private String content;

    private String category;

    private String createAt;

    private List<ReplyResponseDto> replyResponseDto;


    public CommentResponseDto(Comment comment) {
        this.fundId = comment.getCommentId();
        this.content = comment.getContent();
        this.category = comment.getCategory();
        this.id = comment.getId();
        this.fundId = comment.getFindId();
        this.createAt = getCreateAt();   //이거 잘모르겠음
        this.replyResponseDto = getReplyResponseDto();
    }
}
