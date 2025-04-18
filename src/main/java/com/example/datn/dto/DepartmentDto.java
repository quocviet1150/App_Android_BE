package com.example.datn.dto;

import com.example.datn.entity.EmployeeManagement;
import com.example.datn.entity.LeaveManagement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author vietnq
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto implements Serializable {

    private static final long serialVersionUID = -4702619134241314379L;

    private Long id;
    private String departmentName;
    private String headOfDepartment;
    private Long numberOfEmployees;
    private List<EmployeeManagement> employeeManagements;
    private List<LeaveManagement> leaveManagements;
}
