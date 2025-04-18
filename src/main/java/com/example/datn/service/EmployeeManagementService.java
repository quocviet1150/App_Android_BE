package com.example.datn.service;

import com.example.datn.dto.EmployeeDto;
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
    void changeStatus(Long employeeId, Integer status) throws Exception;

    /**
     * Delete employee
     */
    void deleteEmployee(Long employeeId);

    /**
     * Get employee by id
     *
     * @return EmployeeDto
     */
    EmployeeDto getEmployeeById(Long employeeId) throws Exception;
}
