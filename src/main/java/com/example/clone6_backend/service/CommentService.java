package com.example.clone6_backend.service;

import com.example.clone6_backend.dto.response.CommentResponseDto;
import com.example.clone6_backend.dto.response.ReplyResponseDto;
import com.example.clone6_backend.model.Comment;
import com.example.clone6_backend.model.Reply;
import com.example.clone6_backend.repository.CommentRepository;
import com.example.clone6_backend.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ReplyRepository replyRepository;

    private final CommentRepository commentRepository;

    public List<CommentResponseDto> getComment(Long fundId, Long commentId) {
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
        List<Comment> commentList = commentRepository.findByIdOrderByCreatedAtDesc(fundId);
        for(int i = 0; i < commentList.size(); i++){
            // 객체생성
            CommentResponseDto commentResponseDto = new CommentResponseDto(commentList.get(i));
            commentResponseDtos.add(commentResponseDto);
        }
        return commentResponseDtos;
    }
}
