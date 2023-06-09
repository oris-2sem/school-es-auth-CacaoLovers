package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.ParentApi;
import ru.itis.model.Parent;
import ru.itis.service.ParentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ParentController implements ParentApi {

    private final ParentService parentService;


    @Override
    public Parent findEntityById(UUID uuid) {
        return parentService.findById(uuid);
    }

    @Override
    public List<Parent> findAll() {
        return parentService.findAll();
    }

    @Override
    public Parent createEntity(Parent entity) {
        return parentService.createEntity(entity);
    }

    @Override
    public Parent updateEntity(Parent entity) {
        return parentService.updateEntity(entity);
    }

    @Override
    public void deleteEntity(UUID uuid) {
        parentService.deleteEntity(uuid);
    }
}
