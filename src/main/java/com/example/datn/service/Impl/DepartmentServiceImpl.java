package com.example.datn.service.Impl;

import com.example.datn.dto.DepartmentCreateDto;
import com.example.datn.dto.DepartmentDto;
import com.example.datn.entity.Department;
import com.example.datn.entity.LeaveManagement;
import com.example.datn.entity.PersonnelManagement;
import com.example.datn.repository.DepartmentRepository;
import com.example.datn.repository.LeaveManagementRepository;
import com.example.datn.repository.PersonnelManagementRepository;
import com.example.datn.service.DepartmentService;
import com.nimbusds.oauth2.sdk.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PersonnelManagementRepository personnelManagementRepository;

    @Autowired
    private LeaveManagementRepository leaveManagementRepository;

    @Override
    public List<Department> getAllDepartment() {
        List<Department> departments;
        try {
            departments = departmentRepository.findAll();
            return departments;
        } catch (Exception e) {
            e.fillInStackTrace();
            throw e;
        }
    }

    @Override
    public DepartmentDto getLeaveManagementAndPersonnelManagementByDepartment(Long departmentId) {
        DepartmentDto departmentDto = new DepartmentDto();
        try {
            // Get department by id
            Department department = departmentRepository.getById(departmentId);

            // get PersonnelManagement by departmentId
            List<PersonnelManagement> personnelManagements = personnelManagementRepository.findByDepartmentId(departmentId);
            if (CollectionUtils.isNotEmpty(personnelManagements)) {
                departmentDto.setPersonnelManagements(personnelManagements);
            }

            // get LeaveManagement by departmentId
            List<LeaveManagement> leaveManagements = leaveManagementRepository.findByDepartmentId(departmentId);
            if (CollectionUtils.isNotEmpty(personnelManagements)) {
                departmentDto.setLeaveManagements(leaveManagements);
            }

            departmentDto.setId(departmentId);
            departmentDto.setDepartmentName(department.getDepartmentName());
            departmentDto.setHeadOfDepartment(department.getHeadOfDepartment());
            departmentDto.setNumberOfEmployees(department.getNumberOfEmployees());
            return departmentDto;
        } catch (Exception e) {
            e.fillInStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public Department createOrUpdateDepartment(DepartmentCreateDto departmentCreateDto) {
        Department department;
        try {
            if (departmentCreateDto.getId() != null) {
                department = departmentRepository.findById(departmentCreateDto.getId())
                        .orElseThrow(() -> new RuntimeException("Department not found with ID: " + departmentCreateDto.getId()));
            } else {
                department = new Department();
                department.setCreatedDate(new Date());
            }

            department.setDepartmentName(departmentCreateDto.getDepartmentName());
            department.setHeadOfDepartment(departmentCreateDto.getHeadOfDepartment());
            department.setNumberOfEmployees(departmentCreateDto.getNumberOfEmployees());
            department.setUpdatedDate(new Date());

            return departmentRepository.save(department);
        } catch (Exception e) {
            e.fillInStackTrace();
            throw e;
        }
    }
}
