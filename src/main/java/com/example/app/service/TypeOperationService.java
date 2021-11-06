package com.example.app.service;

import com.example.app.model.TypeOperation;

import java.util.List;

public interface TypeOperationService {
    void create(TypeOperation typeOperation);
    void update(TypeOperation newTypeOperation, int id);
    TypeOperation get(int id);
    List<TypeOperation> getAll();
    void delete(int id);
}
