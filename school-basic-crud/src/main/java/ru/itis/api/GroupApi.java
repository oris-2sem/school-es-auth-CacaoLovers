package ru.itis.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.model.Group;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/group")
public interface GroupApi {

    @GetMapping("/{uuid}")
    Group findEntityById(@PathVariable UUID uuid);

    @GetMapping("/list")
    List<Group> findAll();

    @PostMapping
    Group createEntity(@RequestBody Group entity);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    Group updateEntity(@RequestBody Group entity);

    @DeleteMapping("/{uuid}")
    void deleteEntity(@PathVariable UUID uuid);
}
