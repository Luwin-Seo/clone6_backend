package com.example.clone6_backend.service;

import com.example.clone6_backend.dto.request.ReplyRequestDto;
import com.example.clone6_backend.dto.response.ReplyResponseDto;
import com.example.clone6_backend.exceptionHandler.CustomException;
import com.example.clone6_backend.exceptionHandler.ErrorCode;
import com.example.clone6_backend.model.Reply;
import com.example.clone6_backend.repository.ReplyRepository;
import com.example.clone6_backend.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    public ReplyResponseDto createReply(ReplyRequestDto requestDto, Long commentId, UserDetailsImpl userDetails) {
        if(requestDto.getReplyContent().equals("")){
            throw new CustomException(ErrorCode.EMPTY_CONTENT);
        }
        Reply reply = new Reply(requestDto, commentId, userDetails.getUser().getNickname());
        replyRepository.save(reply);
        return new ReplyResponseDto(reply);
    }

    public ReplyResponseDto update(ReplyRequestDto requestDto, Long replyId, UserDetailsImpl userDetails) {
        Reply reply = replyRepository.findById(replyId).orElseThrow(
                () -> new CustomException(ErrorCode.REPLY_NOT_FOUND)
        );
        reply.update(requestDto,userDetails);
        replyRepository.save(reply);
        return new ReplyResponseDto(reply);
    }

    public ResponseEntity delete(Long replyId, UserDetailsImpl userDetails) {
        Reply reply = replyRepository.findById(replyId).orElseThrow(
                () -> new CustomException(ErrorCode.COMMENT_NOT_FOUND)
        );
        if(userDetails.getUser().getId().equals(reply.getId())){
            replyRepository.delete(reply);
            return new ResponseEntity("삭제 완료", HttpStatus.OK);
        }
        throw new CustomException(ErrorCode.INVALID_AUTHORITY);
    }

}
