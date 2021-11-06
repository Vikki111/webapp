package com.example.app.repository;

import com.example.app.model.EmployeeOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeOperationRepository extends JpaRepository<EmployeeOperation, Integer> {
}
