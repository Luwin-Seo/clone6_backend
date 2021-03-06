package com.example.clone6_backend.model;

import com.example.clone6_backend.dto.request.ReplyRequestDto;
import com.example.clone6_backend.security.UserDetailsImpl;
import lombok.*;

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
    private String replyContent;

    @Column
    private String nickname;




    public Reply(ReplyRequestDto requestDto, Long commentId, UserDetailsImpl userDetails) {
        this.id = userDetails.getUser().getId();
        this.replyContent = requestDto.getReplyContent();
        this.commentId = commentId;
        this.nickname = userDetails.getUser().getNickname();
    }

    public void update(ReplyRequestDto requestDto, UserDetailsImpl userDetails) {
        this.id = userDetails.getUser().getId();
        this.replyContent = requestDto.getReplyContent();
        this.nickname = userDetails.getUser().getNickname();
    }
}
