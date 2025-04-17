package com.example.datn.service;

import com.example.datn.dto.LoginDto;
import com.example.datn.dto.UserCreateDto;
import com.example.datn.dto.VerifyDto;
import com.example.datn.entity.User;

import java.util.Map;

/**
 *
 * @author vietnq
 */
public interface UserService {

    User register(UserCreateDto userCreateDto) throws Exception;

    void verify(VerifyDto verifyDto);

    Map<String, String> login(LoginDto loginDto);

    void forgotPassword(String usernameOrEmail);
}
