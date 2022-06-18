package com.example.clone6_backend.service;

import com.example.clone6_backend.dto.request.CommentRequestDto;
import com.example.clone6_backend.dto.response.CommentResponseDto;
import com.example.clone6_backend.dto.response.ReplyResponseDto;
import com.example.clone6_backend.exceptionHandler.CustomException;
import com.example.clone6_backend.exceptionHandler.ErrorCode;
import com.example.clone6_backend.model.Comment;
import com.example.clone6_backend.model.Reply;
import com.example.clone6_backend.repository.CommentRepository;
import com.example.clone6_backend.repository.ReplyRepository;
import com.example.clone6_backend.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class CommentService {

    private final ReplyRepository replyRepository;

    private final CommentRepository commentRepository;

    public List<CommentResponseDto> showComments(CommentResponseDto commentResponseDto, Long fundId, Long replyId){
        // 댓글을 다찾아서 리스트형식의 comments에 담는다.
        List<Comment> comments = commentRepository.findAllByFundId(fundId);
        // commentResponseDtos 의 객체 에 몰아 담아줄려고
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();

        //댓글하나하나들을 comment에 담아준다
        for (Comment comment : comments) {
            // 대댓글들을 모두찾아서 replies에 담는다
            List<Reply> replies = replyRepository.findAllByReplyId(replyId);
            // replyResponseDtos 객체에 리스트들을 담는다
            List<ReplyResponseDto> replyResponseDtos = new ArrayList<>();
            // 대댓글들을 reply에 담는다
            for (Reply reply: replies){
                // replyResponseDto에 담아주는데 어떤애들을 담을지 적어준다.
                ReplyResponseDto replyResponseDto = new ReplyResponseDto(

                );
            }
        }
        }


    public ResponseEntity postComment(CommentRequestDto requestDto, Long fundId, UserDetailsImpl userDetails){
        if(requestDto.getContents().equals("")){
            throw new CustomException(ErrorCode.EMPTY_CONTENT);
        }

    }


}
