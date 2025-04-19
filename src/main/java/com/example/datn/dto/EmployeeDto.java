package com.example.datn.dto;

import com.example.datn.entity.TimeManagement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto implements Serializable {

    private Long id;
    private Long employeeCode;
    private Long departmentId;
    private String fullName;
    private Long level;
    private Long numberOfWorkingDays;
    private Long numberOfOffDays;
    private BigDecimal salary;
    private String directoryPath;
    private Integer status;
    private List<TimeManagement> timeManagements;
}
