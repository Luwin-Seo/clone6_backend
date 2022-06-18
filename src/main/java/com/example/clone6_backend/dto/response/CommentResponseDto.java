package com.example.clone6_backend.dto.response;

import com.example.clone6_backend.dto.request.FundOrderDetailRequestDto;
import com.example.clone6_backend.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private List<ReplyResponseDto> replyResponseDto;


    public CommentResponseDto(Comment comment) {
    }
}
