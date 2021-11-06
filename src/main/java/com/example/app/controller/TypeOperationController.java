package com.example.app.controller;

import com.example.app.model.TypeOperation;
import com.example.app.service.TypeOperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class TypeOperationController {

    private final TypeOperationService typeOperationService;

    @Autowired
    public TypeOperationController(TypeOperationService typeOperationService) {
        this.typeOperationService = typeOperationService;
    }

    @PostMapping(value = "/typeOperations")
    public ResponseEntity<?> create(@RequestBody TypeOperation typeOperation) {
        log.debug("typeOperationBody '{}'", typeOperation);
        typeOperationService.create(typeOperation);
        log.info("new entity is created");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/typeOperations")
    public ResponseEntity<List<TypeOperation>> getAll() {
        final List<TypeOperation> typeOperations = typeOperationService.getAll();
        log.info("get entity");
        return new ResponseEntity<>(typeOperations, HttpStatus.OK);
    }

    @GetMapping(value = "/typeOperations/{id}")
    public ResponseEntity<TypeOperation> get(@PathVariable(name = "id") int id) {
        log.debug("id '{}'", id);
        final TypeOperation typeOperation = typeOperationService.get(id);
        log.debug("typeOperation '{}'", typeOperation);
        return new ResponseEntity<>(typeOperation, HttpStatus.OK);
    }

    @PutMapping(value = "/typeOperations/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id,
                                    @RequestBody TypeOperation typeOperation) {
        log.debug("typeOperationBody '{}'", typeOperation);
        typeOperationService.update(typeOperation, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/typeOperations/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        typeOperationService.delete(id);
        log.debug("id '{}'", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
