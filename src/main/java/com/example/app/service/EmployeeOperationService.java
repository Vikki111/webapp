package com.example.app.service;

import com.example.app.model.EmployeeOperation;

import java.util.List;

public interface EmployeeOperationService {
    void create(EmployeeOperation employeeOperation);
    void update(EmployeeOperation newEmployeeOperation, int id);
    EmployeeOperation get(int id);
    List<EmployeeOperation> getAll();
    void delete(int id);
}
