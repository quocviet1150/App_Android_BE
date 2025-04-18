package com.example.datn.service.Impl;

import com.example.datn.entity.EmployeeManagement;
import com.example.datn.repository.EmployeeManagementRepository;
import com.example.datn.service.EmployeeManagementService;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

    @Autowired
    private EmployeeManagementRepository employeeManagementRepository;

    @Override
    public List<EmployeeManagement> getAllEmployeeByDepartmentId(Long departmentId) throws Exception {
        List<EmployeeManagement> employeeManagements;
        try {
            // Check if departmentId is null or empty
            if (departmentId == null) {
                throw new Exception();
            }
            employeeManagements = employeeManagementRepository.findByDepartmentId(departmentId);
            // Check if employeeManagements is null or empty
            if (Collections.isEmpty(employeeManagements)) {
                throw new Exception();
            }

            // return employeeManagements;
            return employeeManagements;
        } catch (Exception e) {
            e.fillInStackTrace();
            throw e;
        }
    }

    @Override
    public void changeStatus(Long employeeId) {
        try {
            // Check if employeeId is null or empty
            if (employeeId == null) {
                throw new Exception();
            }

            // TODO: Implement the logic to change the status of the employee
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        try {
            // Check if employeeId is null or empty
            if (employeeId == null) {
                throw new Exception();
            }

            // TODO: Implement the logic to delete the employee
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
}
