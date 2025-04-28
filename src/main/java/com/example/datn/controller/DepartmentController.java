package com.example.datn.controller;

import com.example.datn.constant.Constants;
import com.example.datn.dto.DepartmentCreateDto;
import com.example.datn.dto.DepartmentDto;
import com.example.datn.entity.Department;
import com.example.datn.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getAllDepartment")
    public ResponseEntity<?> getAllDepartment() {
        try {
            List<Department> departments = departmentService.getAllDepartment();
            return ResponseEntity.ok(departments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR);
        }
    }

    @GetMapping("/getLeaveManagementAndEmployeeManagementByDepartment/{departmentId}")
    public ResponseEntity<?> getLeaveManagementAndEmployeeManagementByDepartment(@PathVariable("departmentId") Long departmentId) {
        try {
            DepartmentDto departmentDto = departmentService.getLeaveManagementAndEmployeeManagementByDepartment(departmentId);
            return ResponseEntity.ok(departmentDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR);
        }
    }

    @PostMapping("/createOrUpdateDepartment")
    public ResponseEntity<?> createOrUpdateDepartment(@RequestBody DepartmentCreateDto departmentCreateDto) {
        try {
            Department department = departmentService.createOrUpdateDepartment(departmentCreateDto);
            return ResponseEntity.ok(department);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR);
        }
    }

    @PostMapping("/deleteDepartment")
    public ResponseEntity<?> deleteDepartment(@RequestBody Long departmentId) {
        try {
            departmentService.deleteDepartment(departmentId);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR);
        }
    }

    @GetMapping("/getDepartmentById/{departmentId}")
    public ResponseEntity<?> getDepartmentById(@PathVariable("departmentId") Long departmentId) {
        try {
            Department department = departmentService.getDepartmentById(departmentId);
            return ResponseEntity.ok(department);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR);
        }
    }
}
