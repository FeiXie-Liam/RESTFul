package com.example.employee.restfulapi.repository;

import com.example.employee.restfulapi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findById(Long id);

    @Modifying
    @Query("update Company c set c.id=?1 where c.name=?2")
    int setNameFor(String changedName, Long id);
}
