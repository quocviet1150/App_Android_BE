package com.example.datn.repository;

import com.example.datn.entity.TimeManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeManagementRepository extends JpaRepository<TimeManagement, String> {
}
