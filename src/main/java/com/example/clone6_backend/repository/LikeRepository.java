package com.example.clone6_backend.repository;


import com.example.clone6_backend.model.Fund;
import com.example.clone6_backend.model.Likes;
import com.example.clone6_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    Likes findByLikeAndFund(User user, Fund fund);
}
