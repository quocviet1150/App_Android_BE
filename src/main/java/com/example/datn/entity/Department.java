package com.example.datn.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DEPARTMENTS")
@Getter
@Setter
@NoArgsConstructor
public class Department implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DEPARTMENTNAME", length = 100, unique = true)
    private String departmentName;

    @Column(name = "HEADOFDEPARTMENT")
    private String headOfDepartment;

    @Column(name = "NUMBEROFEMPLOYEES")
    private Long numberOfEmployees;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;
}

