package com.example.datn.repository;

import com.example.datn.entity.PersonnelManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnelManagementRepository extends JpaRepository<PersonnelManagement, Long> {

    @Query("SELECT p FROM PersonnelManagement p WHERE p.departmentId =:departmentId")
    List<PersonnelManagement> findByDepartmentId(Long departmentId);
}
