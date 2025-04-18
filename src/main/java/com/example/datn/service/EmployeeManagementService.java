package com.example.datn.service;

import com.example.datn.entity.EmployeeManagement;

import java.util.List;

public interface EmployeeManagementService {

    /**
     * Get all employee by department id
     *
     * @return List<EmployeeManagement>
     */
    List<EmployeeManagement> getAllEmployeeByDepartmentId(Long departmentId) throws Exception;

    /**
     * Change status of employee
     */
    void changeStatus(Long employeeId);

    /**
     * Delete employee
     */
    void deleteEmployee(Long employeeId);
}
