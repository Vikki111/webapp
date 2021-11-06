package com.example.app.service;

import com.example.app.model.Department;
import com.example.app.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void create(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void update(Department newDepartment, int id) {
        if (departmentRepository.existsById(id)) {
            newDepartment.setDepartmentId(id);
            departmentRepository.save(newDepartment);
        }
    }

    @Override
    public Department get(int id) {
        return departmentRepository.getById(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void delete(int id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
        }
    }
}
