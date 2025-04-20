package com.example.datn.service.Impl;

import com.example.datn.entity.TimeManagement;
import com.example.datn.repository.TimeManagementRepository;
import com.example.datn.service.TimeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TimeManagementServiceImpl implements TimeManagementService {

    @Autowired
    private TimeManagementRepository timeManagementRepository;

    @Override
    public TimeManagement create(Long employeeCode) throws ParseException {
        TimeManagement timeManagement = new TimeManagement();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateOnly = sdf.parse(sdf.format(new Date()));
            timeManagement.setWorkday(dateOnly);
            timeManagement.setCheckInTime(new Date());
            timeManagement.setEmployeeCode(employeeCode);
            return timeManagementRepository.save(timeManagement);
        } catch (Exception e) {
            e.fillInStackTrace();
            throw e;
        }
    }
}
