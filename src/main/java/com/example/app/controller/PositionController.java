package com.example.app.controller;

import com.example.app.model.Position;
import com.example.app.service.PositionService;
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
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping(value = "/positions")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody Position position) {
        log.debug("positionBody '{}'", position);
        positionService.create(position);
        log.info("new entity is created");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/positions")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<Position>> getAll() {
        final List<Position> positions = positionService.getAll();
        log.info("get entity");
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }

    @GetMapping(value = "/positions/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Position> get(@PathVariable(name = "id") int id) {
        log.debug("id '{}'", id);
        final Position position = positionService.get(id);
        log.debug("position '{}'", position);
        return new ResponseEntity<>(position, HttpStatus.OK);
    }

    @PutMapping(value = "/positions/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id,
                                    @RequestBody Position position) {
        log.debug("positionBody '{}'", position);
        positionService.update(position, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/positions/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        positionService.delete(id);
        log.debug("id '{}'", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
