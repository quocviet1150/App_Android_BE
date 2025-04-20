package com.example.datn.service;

import com.example.datn.entity.TimeManagement;

import java.text.ParseException;

public interface TimeManagementService {

    /**
     * Creates a new TimeManagement record for the given employee code.
     *
     * @param employeeCode the employee code
     * @return the created TimeManagement entity
     */
    TimeManagement create(String employeeCode) throws ParseException;
}
