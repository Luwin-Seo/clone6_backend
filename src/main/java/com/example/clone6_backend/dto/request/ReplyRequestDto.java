package com.example.clone6_backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReplyRequestDto {
    private Long commentId;
    private String replyContent;
    private String creatAt;
}
