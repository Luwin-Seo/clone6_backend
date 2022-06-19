package com.example.clone6_backend.service;

import com.example.clone6_backend.dto.request.DupCheckRequestDto;
import com.example.clone6_backend.dto.request.SignupRequestDto;
import com.example.clone6_backend.exceptionHandler.CustomException;
import com.example.clone6_backend.exceptionHandler.ErrorCode;
import com.example.clone6_backend.exceptionHandler.NormalResponse;
import com.example.clone6_backend.model.User;
import com.example.clone6_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public ResponseEntity signup(SignupRequestDto requestDto) {
        if (userRepository.findByUsername(requestDto.getUsername()).isPresent()) {
            throw new CustomException(ErrorCode.DUPLICATE_USERNAME);
        }
        User user = new User(requestDto);
        String password = passwordEncoder.encode(requestDto.getPassword());
        user.setPassword(password);
        userRepository.save(user);
        return new ResponseEntity("회원가입이 정상적으로 처리되었습니다", HttpStatus.OK);
    }

    public boolean dupCheck(DupCheckRequestDto requestDto) {
        return !userRepository.findByUsername(requestDto.getUsername()).isPresent();
        }
}

