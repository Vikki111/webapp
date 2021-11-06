package com.example.app.service;

import com.example.app.model.Department;

import java.util.List;

public interface DepartmentService {

    void create(Department department);
    void update(Department newDepartment, int id);
    Department get(int id);
    List<Department> getAll();
    void delete(int id);
}
