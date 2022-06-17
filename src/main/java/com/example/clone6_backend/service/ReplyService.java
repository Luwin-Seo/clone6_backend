package com.example.clone6_backend.service;

import com.example.clone6_backend.dto.request.ReplyRequestDto;
import com.example.clone6_backend.dto.response.ReplyResponseDto;
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
        if(requestDto.getReplyContent() == ""){
            throw new NullPointerException("내용을 입력해주세요.");
        }
        Reply reply = new Reply(requestDto, commentId, userDetails.getUser().getNickname());
        replyRepository.save(reply);
        return new ReplyResponseDto(reply);
    }

    public ReplyResponseDto update(ReplyRequestDto requestDto, Long replyId, UserDetailsImpl userDetails) {
        Reply reply = replyRepository.findById(replyId).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
        reply.update(requestDto,userDetails);
        replyRepository.save(reply);
        return new ReplyResponseDto(reply);
    }

    public ResponseEntity delete(Long replyId, UserDetailsImpl userDetails) {
        Reply reply = replyRepository.findById(replyId).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
        if(userDetails.getUser().getId().equals(reply.getId())){
            replyRepository.delete(reply);
            return new ResponseEntity("삭제 완료", HttpStatus.OK);
        }
        throw new IllegalStateException("작성자만 게시글을 삭제 할수있습니다.");
    }

}
