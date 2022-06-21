package com.example.clone6_backend.dto.response;

import com.example.clone6_backend.model.Comment;
import com.example.clone6_backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {
    private Long fundId;

    private Long commentId;

    private String nickname;

    private String content;

    private String category;

    private String calculatedTime;

    //원투메니 연습 한다고 주석 한거임
    private List<ReplyResponseDto> replyResponseDto;


    public CommentResponseDto(Comment comment, User user) {
        this.fundId = comment.getFundId();
        this.commentId = comment.getCommentId();
        this.nickname = user.getNickname();
        this.content = comment.getContent();
        this.category = comment.getCategory();
        this.calculatedTime = calculatedTime(comment);
    }

    public CommentResponseDto(Comment comment) {
        this.fundId = comment.getFundId();
        this.commentId = comment.getCommentId();
        this.nickname = comment.getNickname();
        this.content = comment.getContent();
        this.category = comment.getCategory();
        this.calculatedTime = calculatedTime(comment);
    }

    //시간 x초 전, x분 전, x시간 전, x일 전, x달 전, x년 전 표시
    public static String calculatedTime(Comment comment) {
        final int SEC = 60;
        final int MIN = 60;
        final int HOUR = 24;
        final int DAY = 30;
        final int MONTH = 12;
        String msg = null;

        LocalDateTime rightNow = LocalDateTime.now();
        LocalDateTime createdAt = comment.getCreatedAt();
        long MILLIS = ChronoUnit.MILLIS.between(createdAt, rightNow);
        long calculate = MILLIS/1000;

        if (calculate < SEC){
            msg = calculate + "초 전";
        } else if ((calculate /= SEC) < MIN) {
            msg = calculate + "분 전";
        } else if ((calculate /= MIN) < HOUR) {
            msg = (calculate) + "시간 전";
        } else if ((calculate /= HOUR) < DAY) {
            msg = (calculate) + "일 전";
        } else if ((calculate /= DAY) < MONTH) {
            msg = (calculate) + "개월 전";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy");
            String curYear = sdf.format(rightNow);
            String passYear = sdf.format(createdAt);
            int diffYear = Integer.parseInt(curYear) - Integer.parseInt(passYear);
            msg = diffYear + "년 전";
        }
        return msg;
    }


}