package com.example.datn.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "EMPLOYEEMANAGEMENTS")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeManagement implements Serializable {

    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMPLOYEECODE", unique = true)
    private String employeeCode;

    @Column(name = "DEPARTMENTID")
    private Long departmentId;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "LEVEL")
    private Long level;

    @Column(name = "NUMBEROFWORKINGDAYS")
    private Long numberOfWorkingDays;

    @Column(name = "NUMBEROFOFFDAYS")
    private Long numberOfOffDays;

    @Column(name = "SALARY")
    private BigDecimal salary;

    @Column(name = "DIRECTORYPATH")
    private String directoryPath;

    @Column(name = "STATUS")
    private Integer status;
}
