package com.example.datn.service.Impl;

import com.example.datn.repository.EmployeeManagementRepository;
import com.example.datn.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

    @Autowired
    private EmployeeManagementRepository employeeManagementRepository;
}
