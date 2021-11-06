package com.example.app.service;

import com.example.app.model.Position;
import com.example.app.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public void create(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void update(Position newPosition, int id) {
        if (positionRepository.existsById(id)) {
            newPosition.setPositionId(id);
            positionRepository.save(newPosition);
        }
    }

    @Override
    public Position get(int id) {
        return positionRepository.getOne(id);
    }

    @Override
    public List<Position> getAll() {
        return positionRepository.findAll();
    }

    @Override
    public void delete(int id) {
        if (positionRepository.existsById(id)) {
            positionRepository.deleteById(id);
        }
    }
}
