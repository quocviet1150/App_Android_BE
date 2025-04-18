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
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME", length = 100, unique = true)
    private String username;

    @Column(name = "EMAIL", length = 100, unique = true)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Column(name = "LASTNAME", nullable = false)
    private String lastName;

    @Column(name = "ISACTIVE", nullable = false)
    private boolean active;

    @Column(name = "CREATEDDATE")
    private Date createdDate;

    @Column(name = "UPDATEDDATE")
    private Date updatedDate;

    @Column(name = "DATEOFBIRTH")
    private Date dateOfBirth;

    @Column(name = "SEX")
    private Integer sex;

    @Column(name = "DIRECTORYPATH")
    private String directoryPath;
}
