package com.example.employee.restfulapi.repository;

import com.example.employee.restfulapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findById(Long id);

    List<Employee> findEmployeesByGenderIs(String gender);

    @Modifying
    @Transactional
    @Query("update Employee c set c.name=?2 where c.id=?1")
    void setNameFor(Long id, String name);
}
