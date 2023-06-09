package ru.itis.api;

import org.springframework.web.bind.annotation.*;
import ru.itis.model.Student;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/student")
public interface StudentApi {
    @GetMapping("/{uuid}")
    Student findEntityById(@PathVariable UUID uuid);

    @GetMapping("/list")
    List<Student> findAll();

    @PostMapping
    Student createEntity(@RequestBody Student entity);

    @PutMapping
    Student updateEntity(@RequestBody Student entity);

    @DeleteMapping("/{uuid}")
    void deleteEntity(@PathVariable UUID uuid);
}
