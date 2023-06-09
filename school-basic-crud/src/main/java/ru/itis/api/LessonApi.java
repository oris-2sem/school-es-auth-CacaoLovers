package ru.itis.api;

import org.springframework.web.bind.annotation.*;
import ru.itis.model.Lesson;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/lesson")
public interface LessonApi {
    @GetMapping("/{uuid}")
    Lesson findEntityById(@PathVariable UUID uuid);

    @GetMapping("/list")
    List<Lesson> findAll();

    @PostMapping
    Lesson createEntity(@RequestBody Lesson entity);

    @PutMapping
    Lesson updateEntity(@RequestBody Lesson entity);

    @DeleteMapping("/{uuid}")
    void deleteEntity(@PathVariable UUID uuid);
}
