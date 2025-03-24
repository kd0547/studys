package com.example.boardexample.controller;

import com.example.boardexample.dto.UserDto;
import com.example.boardexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user/new")
    public void signup(@RequestBody UserDto signupDto) {
        Long id = userService.signup(signupDto);
    }
}
