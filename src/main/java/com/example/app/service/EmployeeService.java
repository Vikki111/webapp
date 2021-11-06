package com.example.app.service;

import com.example.app.model.Employee;

import java.util.List;

public interface EmployeeService {

    void create(Employee employee);
    void update(Employee newEmployee, int id);
    Employee get(int id);
    List<Employee> getAll();
    void delete(int id);
}
