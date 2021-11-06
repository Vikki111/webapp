package com.example.app.service;

import com.example.app.model.Position;

import java.util.List;

public interface PositionService {
    void create(Position position);
    void update(Position newPosition, int id);
    Position get(int id);
    List<Position> getAll();
    void delete(int id);
}
