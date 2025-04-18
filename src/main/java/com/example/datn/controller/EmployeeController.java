package com.example.datn.controller;

import com.example.datn.constant.Constants;
import com.example.datn.dto.EmployeeDto;
import com.example.datn.entity.EmployeeManagement;
import com.example.datn.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeManagementService employeeManagementService;

    @GetMapping("/getAllEmployeeByDepartmentId/{departmentId}")
    public ResponseEntity<?> getAllEmployeeByDepartmentId(@PathVariable Long departmentId) {
        try {
            List<EmployeeManagement> employees = employeeManagementService.getAllEmployeeByDepartmentId(departmentId);
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR);
        }
    }

    @PostMapping("/changeStatus/{employeeId}/{status}")
    public ResponseEntity<?> changeStatus(@PathVariable Long employeeId, @PathVariable Integer status) {
        try {
            employeeManagementService.changeStatus(employeeId, status);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR);
        }
    }


    @PostMapping("/deleteEmployee/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
        try {
            employeeManagementService.deleteEmployee(employeeId);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR);
        }
    }

    @GetMapping("/getEmployeeById/{employeeId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long employeeId) {
        try {
            EmployeeDto employeeDto = employeeManagementService.getEmployeeById(employeeId);
            return ResponseEntity.ok(employeeDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR);
        }
    }
}
