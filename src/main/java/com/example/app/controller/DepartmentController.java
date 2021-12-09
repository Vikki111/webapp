package com.example.app.controller;

import com.example.app.model.Department;
import com.example.app.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(value = "/departments")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody Department department) {
        log.debug("departmentBody '{}'", department);
        departmentService.create(department);
        log.info("new entity is created");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/departments")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<Department>> getAll() {
        final List<Department> departments = departmentService.getAll();
        log.info("get entity");
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping(value = "/departments/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Department> get(@PathVariable(name = "id") int id) {
        log.debug("id '{}'", id);
        final Department department = departmentService.get(id);
        log.debug("department '{}'", department);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PutMapping(value = "/departments/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id,
                                    @RequestBody Department department) {
        log.debug("departmentBody '{}'", department);
        departmentService.update(department, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/departments/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        departmentService.delete(id);
        log.debug("id '{}'", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
