package com.example.clone6_backend.repository;

import com.example.clone6_backend.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAllByReplyId(Long replyId);
}
