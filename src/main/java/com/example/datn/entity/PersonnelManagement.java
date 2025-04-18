package com.example.datn.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PERSONNELMANAGEMENTS")
@Getter
@Setter
@NoArgsConstructor
public class PersonnelManagement {

    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMPLOYEECODE", unique = true)
    private Long employeeCode;

    @Column(name = "DEPARTMENTID")
    private Long departmentId;

    @Column(name = "FULLNAME", length = 255, unique = true)
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
}
