package com.example.datn.repository;

import com.example.datn.entity.EmployeeManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeManagementRepository extends JpaRepository<EmployeeManagement, Long> {

    @Query("SELECT p FROM EmployeeManagement p WHERE p.departmentId =:departmentId")
    List<EmployeeManagement> findByDepartmentId(Long departmentId);

    @Modifying
    @Query("DELETE FROM EmployeeManagement p WHERE p.departmentId =:departmentId")
    void deleteEmployeeManagementsByDepartmentId(Long departmentId);
}
