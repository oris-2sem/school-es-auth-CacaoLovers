package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.TeacherApi;
import ru.itis.dao.TeacherDao;
import ru.itis.model.Teacher;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TeacherController implements TeacherApi {
    private final TeacherDao teacherDao;


    @Override
    public Teacher findEntityById(UUID uuid) {
        return null;
    }

    @Override
    public List<Teacher> findAll() {
        return null;
    }

    @Override
    public Teacher createEntity(Teacher entity) {
        return null;
    }

    @Override
    public Teacher updateEntity(Teacher entity) {
        return null;
    }

    @Override
    public void deleteEntity(UUID uuid) {

    }
}
