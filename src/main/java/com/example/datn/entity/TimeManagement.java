package com.example.datn.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TIMEMANAGEMENTS")
@Getter
@Setter
@NoArgsConstructor
public class TimeManagement implements Serializable {

    private static final long serialVersionUID = 5L;

    @Id
    @Column(name = "ID", unique = true)
    private String id;

    @Column(name = "EMPLOYEECODE", unique = true)
    private Long employeeCode;

    @Column(name = "WORKDAY")
    private Date workday;

    @Column(name = "CHECKINTIME")
    private Date checkInTime;

    @Column(name = "NUMBEROFMINUTESLATEOREARLY")
    private Long numberOfMinutesLateOrEarly;
}
