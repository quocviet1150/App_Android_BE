package com.example.datn.repository;

import com.example.datn.entity.PersonnelManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelManagementRepository extends JpaRepository<PersonnelManagement, Long> {
}
