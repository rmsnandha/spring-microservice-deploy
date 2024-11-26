package com.example.repository;


import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Employee, Long> {
    Employee findByUsername(String username);
}