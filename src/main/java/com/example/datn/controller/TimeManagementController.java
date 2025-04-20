package com.example.datn.controller;

import com.example.datn.constant.Constants;
import com.example.datn.entity.TimeManagement;
import com.example.datn.service.TimeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timeManagement")
public class TimeManagementController {

    @Autowired
    private TimeManagementService timeManagementService;

    @PostMapping("/create/{employeeCode}")
    public ResponseEntity<?> create(@PathVariable String employeeCode) {
        try {
           TimeManagement timeManagement = timeManagementService.create(employeeCode);
            return ResponseEntity.ok(timeManagement);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR);
        }
    }
}
