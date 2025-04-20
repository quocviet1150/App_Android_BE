package com.example.datn.service;

import com.example.datn.dto.EmployeeCreateCameraDto;
import com.example.datn.dto.EmployeeCreateCardDto;
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
    EmployeeDto getEmployeeByEmployeeCode(String employeeCode) throws Exception;

    /**
     * Create employee
     *
     * @return EmployeeManagement
     */
    EmployeeManagement createEmployeeUseCard(EmployeeCreateCardDto employeeCreateCardDto);

    /**
     * Create employee using camera
     *
     * @return EmployeeManagement
     */
    EmployeeManagement createEmployeeUseCamera(EmployeeCreateCameraDto employeeCreateCameraDto) throws Exception;
}
