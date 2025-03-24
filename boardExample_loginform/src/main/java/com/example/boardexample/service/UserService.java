package com.example.boardexample.service;

import com.example.boardexample.Util.AuthUtil;
import com.example.boardexample.dto.UserDto;
import com.example.boardexample.entity.EmailVerificationToken;
import com.example.boardexample.entity.User;
import com.example.boardexample.repository.EmailVerificationTokenRepository;
import com.example.boardexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthUtil authUtil;
    private EmailVerificationTokenRepository emailVerificationTokenRepository;

    private final Long EXPIRED_MINUTES = 15L;

    @Transactional
    public Long signup(UserDto signupDto) {

        User user = User.createUser(signupDto);
        userRepository.save(user);

        EmailVerificationToken emailVerificationToken = new EmailVerificationToken();
        emailVerificationToken.setUser(user);
        emailVerificationToken.setToken(authUtil.createToekn());
        emailVerificationToken.setTime(EXPIRED_MINUTES);

        emailVerificationTokenRepository.save(emailVerificationToken);

        //kafka


        return null;
    }



}
