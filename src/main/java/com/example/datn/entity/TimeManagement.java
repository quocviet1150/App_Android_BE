package com.example.datn.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TIMEMANAGEMENTS")
@Getter
@Setter
@NoArgsConstructor
public class TimeManagement {

    private static final long serialVersionUID = 5L;

    @Id
    @Column(name = "ID", unique = true)
    private String id;

    @Column(name = "PERSONNELMANAGEMENTID")
    private Long personnelManagementId;

    @Column(name = "WORKDAY")
    private Date workday;

    @Column(name = "CHECKINTIME")
    private Date checkInTime;

    @Column(name = "NUMBEROFMINUTESLATEOREARLY")
    private Long numberOfMinutesLateOrEarly;
}
