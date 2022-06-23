package com.example.clone6_backend.controller;

import com.example.clone6_backend.dto.request.CommentRequestDto;
import com.example.clone6_backend.dto.response.CommentResponseDto;
import com.example.clone6_backend.exceptionHandler.CustomException;
import com.example.clone6_backend.exceptionHandler.ErrorCode;
import com.example.clone6_backend.security.UserDetailsImpl;
import com.example.clone6_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/api/fund/{fundId}/comments")
    public List<CommentResponseDto> showComment(@PathVariable Long fundId){
        return commentService.showComments(fundId);
    }

    @PostMapping("/api/fund/{fundId}/comments")
    public ResponseEntity postComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long fundId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(userDetails == null) {throw new CustomException(ErrorCode.AUTH_TOKEN_NOT_FOUND);}
        return commentService.postComment(requestDto, fundId, userDetails);
    }

    @PutMapping("/api/fund/comments/{commentId}")
    public ResponseEntity putComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long commentId, @AuthenticationPrincipal UserDetailsImpl userDetails){
//        if(userDetails == null) {throw new CustomException(ErrorCode.AUTH_TOKEN_NOT_FOUND);}
        return commentService.putComment(requestDto, commentId, userDetails);
    }

    @DeleteMapping("/api/fund/comments/{commentId}")
    public ResponseEntity deleteComment(@PathVariable Long commentId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentService.delete(commentId, userDetails);
    }
}
