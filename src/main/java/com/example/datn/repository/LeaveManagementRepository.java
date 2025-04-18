package com.example.datn.repository;

import com.example.datn.entity.LeaveManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveManagementRepository extends JpaRepository<LeaveManagement, Long> {

    @Query("SELECT l FROM LeaveManagement l WHERE l.departmentId =:departmentId")
    List<LeaveManagement> findByDepartmentId(Long departmentId);

    @Modifying
    @Query("DELETE FROM LeaveManagement l WHERE l.departmentId =:departmentId")
    void deleteLeaveManagementsByDepartmentId(Long departmentId);
}
