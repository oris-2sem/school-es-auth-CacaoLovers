package ru.itis.api;


import org.springframework.web.bind.annotation.*;
import ru.itis.model.Parent;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/parent")
public interface ParentApi {
    @GetMapping("/{uuid}")
    Parent findEntityById(@PathVariable UUID uuid);

    @GetMapping("/list")
    List<Parent> findAll();

    @PostMapping
    Parent createEntity(@RequestBody Parent entity);

    @PutMapping
    Parent updateEntity(@RequestBody Parent entity);

    @DeleteMapping("/{uuid}")
    void deleteEntity(@PathVariable UUID uuid);
}
