package com.example.datn.service.Impl;

import com.example.datn.repository.LeaveManagementRepository;
import com.example.datn.service.LeaveManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveManagementServiceImpl implements LeaveManagementService {

    @Autowired
    private LeaveManagementRepository leaveManagementRepository;
}
