package com.example.clone6_backend.model;

import com.example.clone6_backend.dto.request.ReplyRequestDto;
import com.example.clone6_backend.security.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reply extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long commentId;

    @Column(nullable = false)
    private Long findId;

    @Column(nullable = false)
    private String replyContent;

    public Reply(ReplyRequestDto requestDto, Long commentId, String nickname) {
        this.replyContent = requestDto.getReplyContent();
    }

    public void update(ReplyRequestDto requestDto, UserDetailsImpl userDetails) {
    }
}
