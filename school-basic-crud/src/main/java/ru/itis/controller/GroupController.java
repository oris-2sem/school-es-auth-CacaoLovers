package ru.itis.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.GroupApi;
import ru.itis.model.Group;
import ru.itis.service.GroupService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class GroupController implements GroupApi {

    private final GroupService groupService;

    @Override
    public Group findEntityById(UUID uuid) {
        return groupService.findById(uuid);
    }

    @Override
    public List<Group> findAll() {
        return groupService.findAll();
    }

    @Override
    public Group createEntity(Group entity) {
        return groupService.createEntity(entity);
    }

    @Override
    public Group updateEntity(Group entity) {
        return groupService.updateEntity(entity);
    }

    @Override
    public void deleteEntity(UUID uuid) {
        groupService.deleteEntity(uuid);
    }
}
