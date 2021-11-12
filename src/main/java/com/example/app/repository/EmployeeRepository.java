package com.example.app.repository;

import com.example.app.model.Employee;
import com.example.app.model.EmployeeOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByLastName(String lastName);
}
