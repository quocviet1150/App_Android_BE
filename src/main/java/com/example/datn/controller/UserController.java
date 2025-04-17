package com.example.datn.controller;

import com.example.datn.constant.Constants;
import com.example.datn.dto.LoginDto;
import com.example.datn.dto.UserCreateDto;
import com.example.datn.dto.VerifyDto;
import com.example.datn.entity.User;
import com.example.datn.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 *
 * @author vietnq
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserCreateDto userCreateDto) {
        try {
            User user = userService.register(userCreateDto);
            userCreateDto.setId(user.getId());
            return ResponseEntity.ok(userCreateDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR);
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyCodeAction(@Valid @RequestBody VerifyDto verifyDto) {
        try {
            userService.verify(verifyDto);
            return ResponseEntity.ok(Constants.VALID_VERIFICATION);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.VERIFYING_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) {
        try {
            Map<String, String> response = userService.login(loginDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.VERIFYING_ERROR);
        }
    }

    @PostMapping("/forgotPassword/{usernameOrEmail}")
    public ResponseEntity<?> forgotPassword(@PathVariable String usernameOrEmail) {
        try {
            userService.forgotPassword(usernameOrEmail);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR_EMAIL);
        }
    }
}
