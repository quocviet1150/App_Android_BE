package com.example.datn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentCreateDto implements Serializable {

    private static final long serialVersionUID = 4002389253854367687L;

    private Long id;
    private String departmentName;
    private String headOfDepartment;
    private Long numberOfEmployees;
}
