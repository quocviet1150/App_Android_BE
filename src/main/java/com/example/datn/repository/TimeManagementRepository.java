package com.example.datn.repository;

import com.example.datn.entity.TimeManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeManagementRepository extends JpaRepository<TimeManagement, String> {

    @Query("SELECT t FROM TimeManagement t WHERE t.employeeCode = :employeeCode")
    List<TimeManagement> findTimeManagementsByEmployeeCode(String employeeCode);
}
