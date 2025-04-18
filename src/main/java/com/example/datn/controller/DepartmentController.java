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

    @PostMapping("/getAllDepartment")
    public ResponseEntity<?> getAllDepartment() {
        try {
            List<Department> departments = departmentService.getAllDepartment();
            return ResponseEntity.ok(departments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR);
        }
    }

    @GetMapping("/getLeaveManagementAndPersonnelManagementByDepartment/{departmentId}")
    public ResponseEntity<?> getLeaveManagementAndPersonnelManagementByDepartment( @PathVariable("departmentId") Long departmentId) {
        try {
            DepartmentDto departmentDto = departmentService.getLeaveManagementAndPersonnelManagementByDepartment(departmentId);
            return ResponseEntity.ok(departmentDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR);
        }
    }

    @PostMapping("/createDepartment")
    public ResponseEntity<?> createOrUpdateDepartment(@RequestBody DepartmentCreateDto departmentCreateDto) {
        try {
            Department department = departmentService.createOrUpdateDepartment(departmentCreateDto);
            return ResponseEntity.ok(department);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR);
        }
    }
}
