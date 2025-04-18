package com.example.datn.service.Impl;

import com.example.datn.repository.PersonnelManagementRepository;
import com.example.datn.service.PersonnelManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonnelManagementServiceImpl implements PersonnelManagementService {

    @Autowired
    private PersonnelManagementRepository personnelManagementRepository;
}
