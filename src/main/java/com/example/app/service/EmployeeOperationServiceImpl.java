package com.example.app.service;

import com.example.app.model.EmployeeOperation;
import com.example.app.repository.EmployeeOperationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeOperationServiceImpl implements EmployeeOperationService {

    private EmployeeOperationRepository employeeOperationRepository;

    public EmployeeOperationServiceImpl(EmployeeOperationRepository employeeOperationRepository) {
        this.employeeOperationRepository = employeeOperationRepository;
    }

    @Override
    public void create(EmployeeOperation employeeOperation) {
        employeeOperationRepository.save(employeeOperation);
    }

    @Override
    public void update(EmployeeOperation newEmployeeOperation, int id) {
        if(employeeOperationRepository.existsById(id)) {
            newEmployeeOperation.setOrderNumber(id);
            employeeOperationRepository.save(newEmployeeOperation);
        }
    }

    @Override
    public EmployeeOperation get(int id) {
        return employeeOperationRepository.getById(id);
    }

    @Override
    public List<EmployeeOperation> getAll() {
        return employeeOperationRepository.findAll();
    }

    @Override
    public void delete(int id) {
        if(employeeOperationRepository.existsById(id)) {
            employeeOperationRepository.deleteById(id);
        }
    }
}
