package com.example.app.controller;

import com.example.app.model.Employee;
import com.example.app.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/employees")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        log.debug("employeeBody '{}'", employee);
        employeeService.create(employee);
        log.info("new entity is created");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/employees")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Employee>> getAll() {
        final List<Employee> employees = employeeService.getAll();
        log.info("get entity");
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping(value = "/employees/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Employee> get(@PathVariable(name = "id") int id) {
        log.debug("id '{}'", id);
        final Employee employee = employeeService.get(id);
        log.debug("employee '{}'", employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping(value = "/employees/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id,
                                    @RequestBody Employee employee) {
        log.debug("employeeBody '{}'", employee);
        employeeService.update(employee, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/employees/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        employeeService.delete(id);
        log.debug("id '{}'", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
