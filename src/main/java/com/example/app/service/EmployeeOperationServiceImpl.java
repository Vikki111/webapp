package com.example.app.service;

import com.example.app.model.EmployeeOperation;
import com.example.app.repository.*;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class EmployeeOperationServiceImpl implements EmployeeOperationService {

    private EmployeeOperationRepository employeeOperationRepository;
    private EmployeeRepository employeeRepository;
    private PositionRepository positionRepository;
    private DepartmentRepository departmentRepository;
    private TypeOperationRepository typeOperationRepository;

    public EmployeeOperationServiceImpl(EmployeeOperationRepository employeeOperationRepository,
                                        EmployeeRepository employeeRepository,
                                        PositionRepository positionRepository,
                                        DepartmentRepository departmentRepository,
                                        TypeOperationRepository typeOperationRepository) {
        this.employeeOperationRepository = employeeOperationRepository;
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.departmentRepository = departmentRepository;
        this.typeOperationRepository = typeOperationRepository;
    }

    @Override
    public void create(EmployeeOperation employeeOperation) {
        employeeOperation.setDepartmentId(departmentRepository.findByDepartmentName(employeeOperation.getDepartmentName()).getDepartmentId());
        employeeOperation.setTypeOperationId(typeOperationRepository.findByTypeOperationName(employeeOperation.getTypeOperationName()).getTypeOperationId());
        employeeOperation.setPositionId(positionRepository.findByPositionName(employeeOperation.getPositionName()).getPositionId());
        employeeOperation.setRegNumber(employeeRepository.findByLastName(employeeOperation.getLastName()).getRegNumber());
        employeeOperationRepository.save(employeeOperation);
    }

    @Override
    public void update(EmployeeOperation newEmployeeOperation, int id) {
        if(employeeOperationRepository.existsById(id)) {
            newEmployeeOperation.setOrderNumber(id);
            newEmployeeOperation.setDepartmentId(departmentRepository.findByDepartmentName(newEmployeeOperation.getDepartmentName()).getDepartmentId());
            newEmployeeOperation.setTypeOperationId(typeOperationRepository.findByTypeOperationName(newEmployeeOperation.getTypeOperationName()).getTypeOperationId());
            newEmployeeOperation.setPositionId(positionRepository.findByPositionName(newEmployeeOperation.getPositionName()).getPositionId());
            newEmployeeOperation.setRegNumber(employeeRepository.findByLastName(newEmployeeOperation.getLastName()).getRegNumber());
            employeeOperationRepository.save(newEmployeeOperation);
        }
    }

    @Override
    public EmployeeOperation get(int id) {
        EmployeeOperation employeeOperation = employeeOperationRepository.getById(id);
        employeeOperation.setDepartmentName(departmentRepository.getById(employeeOperation.getDepartmentId()).getDepartmentName());
        employeeOperation.setTypeOperationName(typeOperationRepository.getById(employeeOperation.getTypeOperationId()).getTypeOperationName());
        employeeOperation.setPositionName(positionRepository.getById(employeeOperation.getPositionId()).getPositionName());
        employeeOperation.setLastName(employeeRepository.getById(employeeOperation.getRegNumber()).getLastName());
        return employeeOperation;
//        return employeeOperationRepository.findOneEmployeeOperation();
    }

    @Override
    public List<EmployeeOperation> getAll() {
        List<EmployeeOperation> employeeOperations = employeeOperationRepository.findAll();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (EmployeeOperation employeeOperation: employeeOperations) {
            try {
                employeeOperation.setDateOperation(format.parse(employeeOperation.getDateOperation().toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            employeeOperation.setDepartmentName(departmentRepository.getById(employeeOperation.getDepartmentId()).getDepartmentName());
            employeeOperation.setTypeOperationName(typeOperationRepository.getById(employeeOperation.getTypeOperationId()).getTypeOperationName());
            employeeOperation.setPositionName(positionRepository.getById(employeeOperation.getPositionId()).getPositionName());
            employeeOperation.setLastName(employeeRepository.getById(employeeOperation.getRegNumber()).getLastName());
        }
        return employeeOperations;
    }

    @Override
    public void delete(int id) {
        if(employeeOperationRepository.existsById(id)) {
            employeeOperationRepository.deleteById(id);
        }
    }
}
