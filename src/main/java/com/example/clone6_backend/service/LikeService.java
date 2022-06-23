package com.example.clone6_backend.service;

import com.example.clone6_backend.dto.request.LikeRequestDto;
import com.example.clone6_backend.exceptionHandler.CustomException;
import com.example.clone6_backend.exceptionHandler.ErrorCode;
import com.example.clone6_backend.model.Fund;
import com.example.clone6_backend.model.Likes;
import com.example.clone6_backend.model.User;
import com.example.clone6_backend.repository.FundRepository;
import com.example.clone6_backend.repository.LikeRepository;
import com.example.clone6_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final FundRepository fundRepository;

    public ResponseEntity like(Long fundId, String nickname){
        User user = userRepository.findByNickname(nickname);
            if(!user.equals(nickname)){
                throw new CustomException(ErrorCode.USER_NOT_FOUND);
            }
        Fund fund = fundRepository.findByFundId(fundId);
            if(!fund.equals(fundId)){
                throw new CustomException(ErrorCode.FUND_NOT_FOUND);
            }

            Likes findLike = likeRepository.findByLikeAndFund(user, fund);

            if(findLike == null){
                LikeRequestDto likeRequestDto = new LikeRequestDto(user, fund);
                Likes like = new Likes(likeRequestDto);
                likeRepository.save(like);
                return new ResponseEntity<>("좋아요", HttpStatus.OK);
            } else {
                likeRepository.deleteByFund(findLike.getFund());
                return new ResponseEntity("좋아요 취소",HttpStatus.OK);
            }
    }
}
