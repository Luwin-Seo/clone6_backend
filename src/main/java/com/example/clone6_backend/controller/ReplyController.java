package com.example.clone6_backend.controller;

import com.example.clone6_backend.dto.request.ReplyRequestDto;
import com.example.clone6_backend.dto.response.ReplyResponseDto;
import com.example.clone6_backend.security.UserDetailsImpl;
import com.example.clone6_backend.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/api/fund/comment/{commentId}/reply")
    public ReplyResponseDto createReply(@RequestBody ReplyRequestDto requestDto, @PathVariable Long commentId,@AuthenticationPrincipal UserDetailsImpl userDetails){
        return replyService.createReply(requestDto,commentId,userDetails);
    }

    @PutMapping("/api/fund/commment/{commentId}/reply")
    public ReplyResponseDto update(@RequestBody ReplyRequestDto requestDto, @PathVariable Long commentId,@AuthenticationPrincipal UserDetailsImpl userDetails){
        return replyService.update(requestDto, commentId, userDetails);
    }

    @DeleteMapping("/api/fund/comment/reply/{replyId}")
    public ResponseEntity delete(@PathVariable Long replyId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return replyService.delete(replyId, userDetails);
    }
}
