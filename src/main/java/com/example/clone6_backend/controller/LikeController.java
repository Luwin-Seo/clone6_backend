package com.example.clone6_backend.controller;

import com.example.clone6_backend.security.UserDetailsImpl;
//import com.example.clone6_backend.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequiredArgsConstructor
//@RestController
//public class LikeController {
//
//    private final LikeService likeService;
//
//    @PostMapping("/api/fund/{fundId}/like")
//    public ResponseEntity likes(@PathVariable Long fundId, @AuthenticationPrincipal UserDetailsImpl userDetails){
//        return ResponseEntity.ok().body(likeService.like(fundId, userDetails.getUser().getNickname()));
//    }
//}
