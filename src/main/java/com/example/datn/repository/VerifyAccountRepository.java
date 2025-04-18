package com.example.datn.repository;

import com.example.datn.entity.VerifyAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerifyAccountRepository  extends JpaRepository<VerifyAccount, Long> {

    @Query("SELECT va FROM VerifyAccount va WHERE va.token =:token")
    VerifyAccount findByToken(String token);
}
