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
import com.example.clone6_backend.repository.UserRepository;
import com.example.clone6_backend.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
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
        for(int i = 0; i < commentList.size(); i++){
            Comment comment = commentList.get(i);
            CommentResponseDto commentResponseDto = new CommentResponseDto();
            commentResponseDto.setCommentId(comment.getCommentId());
            commentResponseDto.setFundId(comment.getFundId());
            commentResponseDto.setContent(comment.getContent());
            commentResponseDto.setCategory(comment.getCategory());
            commentResponseDto.setCreateAt(comment.getCreatedAt());
            commentResponseDto.setNickname(userRepository.findById(comment.getId()).orElseThrow(()-> new CustomException(ErrorCode.USER_NOT_FOUND)).getNickname());
        List<ReplyResponseDto> replyResponseDtoList = new ArrayList<>();
        List<Reply> replyList = replyRepository.findAllByCommentId(comment.getCommentId());
            for(int j = 0; j < replyList.size(); j++){
                Reply reply = replyList.get(j);
                ReplyResponseDto replyResponseDto = new ReplyResponseDto();
                replyResponseDto.setCommentId(reply.getCommentId());
                replyResponseDto.setReplyContent(reply.getReplyContent());
                replyResponseDto.setCreateAt(reply.getCreatedAt());
                replyResponseDto.setReplyId(reply.getReplyId());
                replyResponseDto.setNickname(userRepository.findById(reply.getId()).orElseThrow(()-> new CustomException(ErrorCode.USER_NOT_FOUND)).getNickname());
                replyResponseDtoList.add(replyResponseDto);
            }
            commentResponseDto.setReplyResponseDto(replyResponseDtoList);
            commentResponseDtoList.add(commentResponseDto);
        }
        return commentResponseDtoList;
    }

    public ResponseEntity postComment(CommentRequestDto requestDto, Long fundId, UserDetailsImpl userDetails){
        if(requestDto.getContent().equals("")){
            throw new CustomException(ErrorCode.COMMENT_NOT_FOUND);
        }
        Comment comment = new Comment(requestDto, fundId, userDetails);
        commentRepository.save(comment);
        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
        return new ResponseEntity(commentResponseDto, HttpStatus.OK);
    }

    public ResponseEntity putComment(CommentRequestDto requestDto, Long fundId, UserDetailsImpl userDetails){
        Comment comment = commentRepository.findById(fundId).orElseThrow(
                ()-> new CustomException(ErrorCode.COMMENT_NOT_FOUND)
        );
        if(requestDto.getContent().equals("")){
            throw new CustomException(ErrorCode.COMMENT_NOT_FOUND);
        }
        comment.update(requestDto,userDetails);
        commentRepository.save(comment);
        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
        return new ResponseEntity(commentResponseDto, HttpStatus.OK);
    }

    public ResponseEntity delete(Long commentId, UserDetailsImpl userDetails) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new CustomException(ErrorCode.COMMENT_NOT_FOUND)
        );
        if(userDetails.getUser().getNickname().equals(comment.getNickname())){
            commentRepository.delete(comment);
            return new ResponseEntity("삭제 완료",HttpStatus.OK);
        }
        throw new CustomException(ErrorCode.INVALID_AUTHORITY);
    }
}
