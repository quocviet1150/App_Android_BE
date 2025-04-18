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
import java.util.Date;

@Entity
@Table(name = "LEAVEMANAGEMENTS")
@Getter
@Setter
@NoArgsConstructor
public class LeaveManagement {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DEPARTMENTID")
    private Long departmentId;

    @Column(name = "WORKDAY")
    private Date workday;

    @Column(name = "NUMBEROFPEOPLEWORKING")
    private Long numberOfPeopleWorking;

    @Column(name = "NUMBEROFPEOPLEOFF")
    private Long numberOfPeopleOff;
}
