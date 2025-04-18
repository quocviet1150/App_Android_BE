package com.example.datn.service.Impl;

import com.example.datn.repository.DepartmentRepository;
import com.example.datn.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
}
