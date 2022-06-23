package com.example.clone6_backend.service;


import com.example.clone6_backend.dto.request.CommentRequestDto;
import com.example.clone6_backend.dto.response.CommentResponseDto;
import com.example.clone6_backend.dto.response.ReplyResponseDto;
import com.example.clone6_backend.exceptionHandler.CustomException;
import com.example.clone6_backend.exceptionHandler.ErrorCode;
import com.example.clone6_backend.model.Comment;
import com.example.clone6_backend.model.Reply;
import com.example.clone6_backend.model.User;
import com.example.clone6_backend.repository.CommentRepository;
import com.example.clone6_backend.repository.ReplyRepository;
import com.example.clone6_backend.repository.UserRepository;
import com.example.clone6_backend.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ReplyRepository replyRepository;

    private final CommentRepository commentRepository;

    private final UserRepository userRepository;

    public List<CommentResponseDto> showComments(Long fundId){
        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
        List<Comment> commentList = commentRepository.findAllByFundId(fundId);
        for(Comment comment : commentList){
            User user = userRepository.findById(comment.getId()).orElseThrow(()-> new CustomException(ErrorCode.USER_NOT_FOUND));
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment,user);
        List<ReplyResponseDto> replyResponseDtoList = new ArrayList<>();
        List<Reply> replyList = replyRepository.findAllByCommentId(comment.getCommentId());
        for(Reply reply : replyList){
            User user1 = userRepository.findById(reply.getId()).orElseThrow(()-> new CustomException(ErrorCode.USER_NOT_FOUND));
                ReplyResponseDto replyResponseDto = new ReplyResponseDto(reply, user1);
                replyResponseDtoList.add(replyResponseDto);
            }
            commentResponseDto.setReplyResponseDto(replyResponseDtoList);
            commentResponseDtoList.add(commentResponseDto);
        }
        return commentResponseDtoList;
    }

    public ResponseEntity postComment(CommentRequestDto requestDto, Long fundId, UserDetailsImpl userDetails){
        if(requestDto.getContent()==null){
            throw new CustomException(ErrorCode.COMMENT_NOT_FOUND);
        }
        Comment comment = new Comment(requestDto, fundId, userDetails);
        commentRepository.save(comment);
        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
        return new ResponseEntity(commentResponseDto, HttpStatus.OK);
    }

    public ResponseEntity putComment(CommentRequestDto requestDto, Long commentId, UserDetailsImpl userDetails) {
        Comment comment = commentRepository.findByCommentId(commentId);
        if (requestDto.getContent().equals("")) {
            throw new CustomException(ErrorCode.COMMENT_NOT_FOUND);
        }
        if (userDetails.getUser().getId().equals(comment.getId())) {
            comment.update(requestDto, userDetails);
            commentRepository.save(comment);
        }else{
            throw new CustomException(ErrorCode.INVALID_AUTHORITY);
        }
        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
        return new ResponseEntity(commentResponseDto, HttpStatus.OK);
    }

    public ResponseEntity delete(Long commentId, UserDetailsImpl userDetails) {
        Comment comment = commentRepository.findByCommentId(commentId);
        if(userDetails.getUser().getId().equals(comment.getId())){
            commentRepository.delete(comment);
            return new ResponseEntity("삭제 완료",HttpStatus.OK);
        } else{
            throw new CustomException(ErrorCode.INVALID_AUTHORITY);
        }
    }
}
