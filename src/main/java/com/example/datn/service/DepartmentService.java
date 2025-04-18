package com.example.datn.service;

import com.example.datn.dto.DepartmentCreateDto;
import com.example.datn.dto.DepartmentDto;
import com.example.datn.entity.Department;

import java.util.List;

public interface DepartmentService {

    /**
     * Get all department
     *
     * @return Department
     */
    List<Department> getAllDepartment();

    /**
     * Get leave management and personnel management by department
     *
     * @return DepartmentDto
     */
    DepartmentDto getLeaveManagementAndPersonnelManagementByDepartment(Long departmentId);

    /**
     * Create department
     *
     * @return Department
     */
    Department createOrUpdateDepartment(DepartmentCreateDto departmentCreateDto);
}
