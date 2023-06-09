package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.TimetableApi;
import ru.itis.model.Timetable;
import ru.itis.service.TimetableService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TimetableController implements TimetableApi {

    private final TimetableService timetableService;
    @Override
    public Timetable findEntityById(UUID uuid) {
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
