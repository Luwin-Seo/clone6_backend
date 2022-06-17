package com.example.clone6_backend.service;

import com.example.clone6_backend.dto.response.CommentResponseDto;
import com.example.clone6_backend.dto.response.ReplyResponseDto;
import com.example.clone6_backend.model.Comment;
import com.example.clone6_backend.model.Reply;
import com.example.clone6_backend.repository.CommentRepository;
import com.example.clone6_backend.repository.ReplyRepository;
import com.example.clone6_backend.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ReplyRepository replyRepository;

    private final CommentRepository commentRepository;

    public ReplyResponseDto showComments(CommentResponseDto responseDto, Long fundId, UserDetailsImpl userDetails){

    }
}
