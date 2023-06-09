package ru.itis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.model.Timetable;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TimetableService implements EntityCrudService<Timetable, UUID>{
    @Override
    public Timetable findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Timetable> findAll() {
        return null;
    }

    @Override
    public Timetable createEntity(Timetable entity) {
        return null;
    }

    @Override
    public Timetable updateEntity(Timetable entity) {
        return null;
    }

    @Override
    public void deleteEntity(UUID uuid) {

    }
}
