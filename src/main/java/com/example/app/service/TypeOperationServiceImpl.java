package com.example.app.service;

import com.example.app.model.TypeOperation;
import com.example.app.repository.TypeOperationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOperationServiceImpl implements TypeOperationService {

    private final TypeOperationRepository typeOperationRepository;

    public TypeOperationServiceImpl(TypeOperationRepository typeOperationRepository) {
        this.typeOperationRepository = typeOperationRepository;
    }

    @Override
    public void create(TypeOperation typeOperation) {
        typeOperationRepository.save(typeOperation);
    }

    @Override
    public void update(TypeOperation newTypeOperation, int id) {
        if(typeOperationRepository.existsById(id)) {
            newTypeOperation.setTypeOperationId(id);
            typeOperationRepository.save(newTypeOperation);
        }
    }

    @Override
    public TypeOperation get(int id) {
        return typeOperationRepository.getById(id);
    }

    @Override
    public List<TypeOperation> getAll() {
        return typeOperationRepository.findAll();
    }

    @Override
    public void delete(int id) {
        if (typeOperationRepository.existsById(id)) {
            typeOperationRepository.deleteById(id);
        }
    }
}
