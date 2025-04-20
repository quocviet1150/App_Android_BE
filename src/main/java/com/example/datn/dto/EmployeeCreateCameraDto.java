package com.example.datn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateCameraDto implements Serializable {

    private String employeeCode;
    private Long departmentId;
    private String fullName;
    private Long level;
    private BigDecimal salary;
    private Integer status;
    private String base64Image;
}
