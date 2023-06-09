package ru.itis.api;

import org.springframework.web.bind.annotation.*;
import ru.itis.model.Timetable;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/timetable")
public interface TimetableApi {
    @GetMapping("/{uuid}")
    Timetable findEntityById(@PathVariable UUID uuid);

    @GetMapping("/list")
    List<Timetable> findAll();

    @PostMapping
    Timetable createEntity(@RequestBody Timetable entity);

    @PutMapping
    Timetable updateEntity(@RequestBody Timetable entity);

    @DeleteMapping("/{uuid}")
    void deleteEntity(@PathVariable UUID uuid);
}
