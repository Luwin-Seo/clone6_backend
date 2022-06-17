package com.example.clone6_backend.controller;

import com.example.clone6_backend.dto.request.CommentRequestDto;
import com.example.clone6_backend.dto.response.CommentResponseDto;
import com.example.clone6_backend.exceptionHandler.CustomException;
import com.example.clone6_backend.exceptionHandler.ErrorCode;
import com.example.clone6_backend.model.Comment;
import com.example.clone6_backend.repository.CommentRepository;
import com.example.clone6_backend.security.UserDetailsImpl;
import com.example.clone6_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;

    private final CommentService commentService;

//    @GetMapping("/api/fund/{fundId}/comments")
//    public List<CommentResponseDto> showComment(@PathVariable Long fundId) {
//
////        return commentService.getComment(fundId);
//    }

    @PostMapping("/api/fund/{fundId}/comment")
    public CommentResponseDto createComment(CommentRequestDto requestDto, @PathVariable Long fundId, UserDetailsImpl userDetails) {
        if(userDetails == null) {throw new CustomException(ErrorCode.AUTH_TOKEN_NOT_FOUND);}
        if(requestDto.getComment().equals("")){
            throw new CustomException(ErrorCode.EMPTY_CONTENT);
        }
        Comment comment = new Comment(requestDto, fundId, userDetails);
        commentRepository.save(comment);
        return new CommentResponseDto(comment);
    }
}
