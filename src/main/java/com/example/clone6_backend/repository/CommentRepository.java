package com.example.clone6_backend.repository;

import com.example.clone6_backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByFundId(Long fundId);
}
