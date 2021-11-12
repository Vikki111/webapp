package com.example.app.repository;

import com.example.app.model.Position;
import com.example.app.model.TypeOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOperationRepository extends JpaRepository<TypeOperation, Integer> {
    TypeOperation findByTypeOperationName(String typeOperationName);
}
