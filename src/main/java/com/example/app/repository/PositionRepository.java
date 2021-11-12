package com.example.app.repository;

import com.example.app.model.Department;
import com.example.app.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    Position findByPositionName(String positionName);
}
