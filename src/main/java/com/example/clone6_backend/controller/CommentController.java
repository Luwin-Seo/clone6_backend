package com.example.clone6_backend.controller;

import com.example.clone6_backend.dto.request.CommentRequestDto;
import com.example.clone6_backend.dto.response.CommentResponseDto;
import com.example.clone6_backend.exceptionHandler.CustomException;
import com.example.clone6_backend.exceptionHandler.ErrorCode;
import com.example.clone6_backend.repository.CommentRepository;
import com.example.clone6_backend.security.UserDetailsImpl;
import com.example.clone6_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;

    private final CommentService commentService;

    @GetMapping("/api/fund/{fundId}/comments")
    public List<CommentResponseDto> showComment(@RequestBody CommentResponseDto responseDto, @AuthenticationPrincipal Long fundId){
        return commentService.showComments(responseDto,fundId);
    }

    @PostMapping("/api/fund/{fundId}/comment")
    public ResponseEntity postComment(@RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal Long fundId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        if(userDetails == null) {throw new CustomException(ErrorCode.AUTH_TOKEN_NOT_FOUND);}
        return commentService.postComment(requestDto, fundId, userDetails);
    }

    @PutMapping



}
