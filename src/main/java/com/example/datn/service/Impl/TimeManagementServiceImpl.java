package com.example.datn.service.Impl;

import com.example.datn.repository.TimeManagementRepository;
import com.example.datn.service.TimeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeManagementServiceImpl implements TimeManagementService {

    @Autowired
    private TimeManagementRepository timeManagementRepository;
}
