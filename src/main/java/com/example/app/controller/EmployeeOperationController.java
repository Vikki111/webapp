package com.example.app.controller;

import com.example.app.model.EmployeeOperation;
import com.example.app.service.EmployeeOperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class EmployeeOperationController {

    private final EmployeeOperationService employeeOperationService;

    @Autowired
    public EmployeeOperationController(EmployeeOperationService employeeOperationService) {
        this.employeeOperationService = employeeOperationService;
    }

    @PostMapping(value = "/employeeOperations")
    public ResponseEntity<?> create(@RequestBody EmployeeOperation employeeOperation) {
        log.debug("employeeOperationBody '{}'", employeeOperation);
        employeeOperationService.create(employeeOperation);
        log.info("new entity is created");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/employeeOperations")
    public ResponseEntity<List<EmployeeOperation>> getAll() {
        final List<EmployeeOperation> employeeOperations = employeeOperationService.getAll();
        log.info("get entity");
        return new ResponseEntity<>(employeeOperations, HttpStatus.OK);
    }

    @GetMapping(value = "/employeeOperations/{id}")
    public ResponseEntity<EmployeeOperation> get(@PathVariable(name = "id") int id) {
        log.debug("id '{}'", id);
        final EmployeeOperation employeeOperation = employeeOperationService.get(id);
        log.debug("employeeOperation '{}'", employeeOperation);
        return new ResponseEntity<>(employeeOperation, HttpStatus.OK);
    }

    @PutMapping(value = "/employeeOperations/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id,
                                    @RequestBody EmployeeOperation employeeOperation) {
        log.debug("employeeOperationBody '{}'", employeeOperation);
        employeeOperationService.update(employeeOperation, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/employeeOperations/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        employeeOperationService.delete(id);
        log.debug("id '{}'", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
