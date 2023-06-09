package ru.itis.api;

import org.springframework.web.bind.annotation.*;
import ru.itis.model.Teacher;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/teacher")
public interface TeacherApi {
    @GetMapping("/{uuid}")
    Teacher findEntityById(@PathVariable UUID uuid);

    @GetMapping("/list")
    List<Teacher> findAll();

    @PostMapping
    Teacher createEntity(@RequestBody Teacher entity);

    @PutMapping
    Teacher updateEntity(@RequestBody Teacher entity);

    @DeleteMapping("/{uuid}")
    void deleteEntity(@PathVariable UUID uuid);
}
